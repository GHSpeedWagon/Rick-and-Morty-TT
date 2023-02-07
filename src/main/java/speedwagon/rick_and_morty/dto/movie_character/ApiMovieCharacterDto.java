package speedwagon.rick_and_morty.dto.movie_character;

import java.util.List;
import lombok.Data;
import speedwagon.rick_and_morty.model.Location;

@Data
public class ApiMovieCharacterDto {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
