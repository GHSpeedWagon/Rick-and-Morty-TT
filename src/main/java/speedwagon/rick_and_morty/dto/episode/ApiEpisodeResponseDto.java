package speedwagon.rick_and_morty.dto.episode;

import lombok.Data;
import speedwagon.rick_and_morty.dto.ApiInfoDto;

@Data
public class ApiEpisodeResponseDto {
    private ApiInfoDto info;
    private ApiEpisodeDto[] results;
}
