package speedwagon.rick_and_morty.dto.location;

import lombok.Data;
import speedwagon.rick_and_morty.dto.ApiInfoDto;

@Data
public class ApiLocationResponseDto {
    private ApiInfoDto info;
    private ApiLocationDto[] results;
}
