package speedwagon.rick_and_morty.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speedwagon.rick_and_morty.dto.mapper.MovieCharacterMapper;
import speedwagon.rick_and_morty.dto.movie_character.ApiMovieCharacterDto;
import speedwagon.rick_and_morty.model.MovieCharacter;
import speedwagon.rick_and_morty.service.MovieCharacterService;
import speedwagon.rick_and_morty.service.RandomCharacterGenerator;

@RestController
@RequestMapping("/movie/rick-and-morty/character")
public class MovieCharacterController {
    private final MovieCharacterMapper movieCharacterMapper;
    private final RandomCharacterGenerator randomCharacterGenerator;
    private final MovieCharacterService movieCharacterService;

    public MovieCharacterController(
            MovieCharacterMapper movieCharacterMapper,
            RandomCharacterGenerator randomCharacterGenerator,
            MovieCharacterService movieCharacterService) {
        this.movieCharacterMapper = movieCharacterMapper;
        this.randomCharacterGenerator = randomCharacterGenerator;
        this.movieCharacterService = movieCharacterService;
    }

    @ApiOperation(value = "create random character from Rick and Morty universe")
    @GetMapping("/random")
    public ApiMovieCharacterDto getRandomMovieCharacter() {
        return movieCharacterMapper.toDto(randomCharacterGenerator.getRandomMovieCharacter());
    }

    @ApiOperation(value = "find all characters from Rick and Morty universe by name")
    @GetMapping("/find-by-name/{name}")
    public List<ApiMovieCharacterDto> getByName(@PathVariable String name) {
        List<MovieCharacter> movieCharacterListByName = movieCharacterService.getByName(name);
        return movieCharacterListByName.stream()
                .map(movieCharacterMapper::toDto)
                .toList();
    }
}
