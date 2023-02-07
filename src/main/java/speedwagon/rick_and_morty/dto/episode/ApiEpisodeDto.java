package speedwagon.rick_and_morty.dto.episode;

import java.util.List;
import lombok.Data;

@Data
public class ApiEpisodeDto {
    private Long id;
    private String name;
    private String airDate;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;
}
