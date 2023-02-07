package speedwagon.rick_and_morty.dto.location;

import java.util.List;
import lombok.Data;

@Data
public class ApiLocationDto {
    private Long id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;
}
