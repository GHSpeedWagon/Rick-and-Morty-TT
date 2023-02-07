package speedwagon.rick_and_morty.dto.movie_character;

import lombok.Data;
import speedwagon.rick_and_morty.dto.ApiInfoDto;

@Data
public class ApiMovieCharacterResponseDto {
    private ApiInfoDto info;
    private ApiMovieCharacterDto[] results;
}
