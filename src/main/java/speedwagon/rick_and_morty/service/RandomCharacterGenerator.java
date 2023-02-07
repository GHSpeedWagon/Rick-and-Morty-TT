package speedwagon.rick_and_morty.service;

import java.util.Random;
import org.springframework.stereotype.Component;
import speedwagon.rick_and_morty.model.MovieCharacter;

@Component
public class RandomCharacterGenerator {
    private final MovieCharacterService movieCharacterService;
    private int dataBaseSize;

    public RandomCharacterGenerator(MovieCharacterService movieCharacterService) {
        this.movieCharacterService = movieCharacterService;
        dataBaseSize = Math.toIntExact(movieCharacterService.getMaxId());
    }

    public MovieCharacter getRandomMovieCharacter() {
        MovieCharacter movieCharacter = new MovieCharacter();
        while (movieCharacter.getName() == null) {
            movieCharacter
                    .setName(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                            .getName());
        }
        while (movieCharacter.getStatus() == null) {
            movieCharacter
                    .setStatus(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                            .getStatus());
        }
        while (movieCharacter.getSpecies() == null) {
            movieCharacter
                    .setSpecies(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                            .getSpecies());
        }
        while (movieCharacter.getType() == null) {
            movieCharacter
                    .setType(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                            .getType());
        }
        while (movieCharacter.getGender() == null) {
            movieCharacter
                    .setGender(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                            .getGender());
        }
        while (movieCharacter.getOrigin() == null) {
            movieCharacter
                    .setOrigin(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                                    .getOrigin());
        }
        while (movieCharacter.getLocation() == null) {
            movieCharacter
                    .setLocation(
                            movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                                    .getLocation());
        }
        while (movieCharacter.getImage() == null) {
            movieCharacter
                    .setImage(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                            .getImage());
        }
        while (movieCharacter.getEpisode() == null) {
            movieCharacter
                    .setEpisode(movieCharacterService.get((long) new Random().nextInt(dataBaseSize))
                                    .getEpisode());
        }
        return movieCharacter;
    }
}
