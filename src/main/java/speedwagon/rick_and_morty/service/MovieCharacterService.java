package speedwagon.rick_and_morty.service;

import java.util.List;
import speedwagon.rick_and_morty.model.MovieCharacter;

public interface MovieCharacterService {
    MovieCharacter save(MovieCharacter movieCharacter);

    String saveAll(List<MovieCharacter> movieCharacters);

    MovieCharacter get(Long id);

    Long getMaxId();

    MovieCharacter update(MovieCharacter movieCharacter);

    List<MovieCharacter> getByName(String name);
}
