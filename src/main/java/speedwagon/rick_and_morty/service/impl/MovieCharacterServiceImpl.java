package speedwagon.rick_and_morty.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import speedwagon.rick_and_morty.model.MovieCharacter;
import speedwagon.rick_and_morty.repository.MovieCharacterRepository;
import speedwagon.rick_and_morty.service.MovieCharacterService;

@Service
public class MovieCharacterServiceImpl implements MovieCharacterService {
    private final MovieCharacterRepository movieCharacterRepository;

    public MovieCharacterServiceImpl(MovieCharacterRepository movieCharacterRepository) {
        this.movieCharacterRepository = movieCharacterRepository;
    }

    @Override
    public MovieCharacter save(MovieCharacter movieCharacter) {
        return movieCharacterRepository.save(movieCharacter);
    }

    @Override
    public String saveAll(List<MovieCharacter> movieCharacters) {
        movieCharacterRepository.saveAll(movieCharacters);
        return "List of movie characters was saved";
    }

    @Override
    public MovieCharacter get(Long id) {
        return movieCharacterRepository.getReferenceById(id);
    }

    public Long getMaxId() {
        return movieCharacterRepository.findMaxId();
    }

    @Override
    public MovieCharacter update(MovieCharacter movieCharacter) {
        return movieCharacterRepository.save(movieCharacter);
    }

    public List<MovieCharacter> getByName(String name) {
        return movieCharacterRepository.getAllByNameContains(name);
    }
}
