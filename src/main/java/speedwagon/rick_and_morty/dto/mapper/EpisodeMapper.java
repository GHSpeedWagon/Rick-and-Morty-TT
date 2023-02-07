package speedwagon.rick_and_morty.dto.mapper;

import org.springframework.stereotype.Component;
import speedwagon.rick_and_morty.dto.episode.ApiEpisodeDto;
import speedwagon.rick_and_morty.model.Episode;
import speedwagon.rick_and_morty.model.MovieCharacter;

@Component
public class EpisodeMapper {
    public Episode toModel(ApiEpisodeDto apiEpisodeDto) {
        Episode episode = new Episode();
        episode.setId(apiEpisodeDto.getId());
        episode.setName(apiEpisodeDto.getName());
        episode.setEpisode(apiEpisodeDto.getEpisode());
        episode.setAirDate(apiEpisodeDto.getAirDate());
        episode.setMovieCharacters(apiEpisodeDto.getCharacters()
                .stream()
                .map(this::setMovieCharactersUrl)
                .toList());
        episode.setUrl(apiEpisodeDto.getUrl());
        episode.setCreated(apiEpisodeDto.getCreated());
        return episode;
    }

    private MovieCharacter setMovieCharactersUrl(String url) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setUrl(url);
        return movieCharacter;
    }
}
