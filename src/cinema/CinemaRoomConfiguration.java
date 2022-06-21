package cinema;

import cinema.model.CinemaRoom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaRoomConfiguration {

    @Bean
    public CinemaRoom cinemaRoom(@Value("${cinema.room.rows}") int rows, @Value("${cinema.room.columns}") int columns) {
        return new CinemaRoom(rows, columns);
    }

}
