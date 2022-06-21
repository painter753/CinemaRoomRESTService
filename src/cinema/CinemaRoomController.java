package cinema;

import cinema.model.RoomInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CinemaRoomController {

    private final RoomInfoProvider roomInfoProvider;

    public CinemaRoomController(RoomInfoProvider roomInfoProvider) {
        this.roomInfoProvider = roomInfoProvider;
    }

    @GetMapping("/seats")
    public RoomInfo getInfo() {
        return roomInfoProvider.getInfo();
    }
}
