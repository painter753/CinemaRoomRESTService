package cinema;

import cinema.model.request.RefundRequest;
import cinema.model.response.ErrorResponse;
import cinema.model.request.SeatOrderRequest;
import cinema.service.CinemaStatisticsService;
import cinema.service.CredentialsValidator;
import cinema.service.RoomInfoService;
import cinema.service.SeatPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaRoomController {

    private final RoomInfoService roomInfoService;
    private final SeatPurchaseService seatPurchaseService;
    private final CinemaStatisticsService cinemaStatisticsService;
    private final CredentialsValidator credentialsValidator;

    public CinemaRoomController(RoomInfoService roomInfoService,
                                SeatPurchaseService seatPurchaseService,
                                CinemaStatisticsService cinemaStatisticsService,
                                CredentialsValidator credentialsValidator) {
        this.roomInfoService = roomInfoService;
        this.seatPurchaseService = seatPurchaseService;
        this.cinemaStatisticsService = cinemaStatisticsService;
        this.credentialsValidator = credentialsValidator;
    }

    @GetMapping("/seats")
    public ResponseEntity getInfo() {
        return ResponseEntity.ok(roomInfoService.getInfo());
    }

    @PostMapping("/purchase")
    public ResponseEntity purchase(@RequestBody SeatOrderRequest order) {
        try {
            return ResponseEntity.ok(seatPurchaseService.order(order.getRow(), order.getColumn()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/return")
    public ResponseEntity returnTicket(@RequestBody RefundRequest refund) {
        try {
         return ResponseEntity.ok(seatPurchaseService.refund(refund.getToken()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/stats")
    public ResponseEntity stats(@RequestParam(required = false) String password) {
        try {
            credentialsValidator.validate(password);
            return ResponseEntity.ok(cinemaStatisticsService.getStats());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(e.getMessage()));
        }
    }
}
