package cinema;

import cinema.model.ErrorResponse;
import cinema.model.SeatOrder;
import cinema.service.RoomInfoService;
import cinema.service.SeatPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaRoomController {

    private final RoomInfoService roomInfoService;
    private final SeatPurchaseService seatPurchaseService;

    public CinemaRoomController(RoomInfoService roomInfoService, SeatPurchaseService seatPurchaseService) {
        this.roomInfoService = roomInfoService;
        this.seatPurchaseService = seatPurchaseService;
    }

    @GetMapping("/seats")
    public ResponseEntity getInfo() {
        return ResponseEntity.ok(roomInfoService.getInfo());
    }

    @PostMapping("/purchase")
    public ResponseEntity purchase(@RequestBody SeatOrder order) {
        try {
            return ResponseEntity.ok(seatPurchaseService.order(order.getRow(), order.getColumn()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }
}
