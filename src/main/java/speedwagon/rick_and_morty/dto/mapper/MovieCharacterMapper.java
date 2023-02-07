package speedwagon.rick_and_morty.dto.mapper;

import org.springframework.stereotype.Component;
import speedwagon.rick_and_morty.dto.movie_character.ApiMovieCharacterDto;
import speedwagon.rick_and_morty.model.Episode;
import speedwagon.rick_and_morty.model.MovieCharacter;
import speedwagon.rick_and_morty.model.enums.Gender;
import speedwagon.rick_and_morty.model.enums.Status;

@Component
public class MovieCharacterMapper {

    public MovieCharacter toModel(ApiMovieCharacterDto apiMovieCharacterDto) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setId(apiMovieCharacterDto.getId());
        movieCharacter.setName(apiMovieCharacterDto.getName());
        movieCharacter.setStatus(Status.getStatus(apiMovieCharacterDto.getStatus()));
        movieCharacter.setSpecies(apiMovieCharacterDto.getSpecies());
        movieCharacter.setType(apiMovieCharacterDto.getType());
        movieCharacter.setGender(Gender.getGender(apiMovieCharacterDto.getGender()));
        movieCharacter.setOrigin(apiMovieCharacterDto.getOrigin());
        movieCharacter.setLocation(apiMovieCharacterDto.getLocation());
        movieCharacter.setImage(apiMovieCharacterDto.getImage());
        movieCharacter.setEpisode(apiMovieCharacterDto.getEpisode()
                .stream()
                .map(this::setEpisodeUrl)
                .toList());
        movieCharacter.setUrl(apiMovieCharacterDto.getUrl());
        movieCharacter.setCreated(apiMovieCharacterDto.getCreated());
        return movieCharacter;
    }

    private Episode setEpisodeUrl(String url) {
        Episode episode = new Episode();
        episode.setUrl(url);
        return episode;
    }

    public ApiMovieCharacterDto toDto(MovieCharacter movieCharacter) {
        ApiMovieCharacterDto apiMovieCharacterDto = new ApiMovieCharacterDto();
        apiMovieCharacterDto.setId(movieCharacter.getId());
        apiMovieCharacterDto.setName(movieCharacter.getName());
        apiMovieCharacterDto.setStatus(String.valueOf(movieCharacter.getStatus()));
        apiMovieCharacterDto.setSpecies(movieCharacter.getSpecies());
        apiMovieCharacterDto.setType(movieCharacter.getType());
        apiMovieCharacterDto.setGender(String.valueOf(movieCharacter.getGender()));
        apiMovieCharacterDto.setOrigin(movieCharacter.getOrigin());
        apiMovieCharacterDto.setLocation(movieCharacter.getLocation());
        apiMovieCharacterDto.setImage(movieCharacter.getImage());
        apiMovieCharacterDto.setEpisode(movieCharacter.getEpisode()
                .stream()
                .map(String::valueOf)
                .toList());
        apiMovieCharacterDto.setUrl(movieCharacter.getUrl());
        apiMovieCharacterDto.setCreated(movieCharacter.getCreated());
        return apiMovieCharacterDto;
    }
}
