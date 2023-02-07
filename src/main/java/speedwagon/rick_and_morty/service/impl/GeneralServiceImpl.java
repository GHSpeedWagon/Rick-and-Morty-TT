package speedwagon.rick_and_morty.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import speedwagon.rick_and_morty.dto.episode.ApiEpisodeResponseDto;
import speedwagon.rick_and_morty.dto.location.ApiLocationResponseDto;
import speedwagon.rick_and_morty.dto.mapper.EpisodeMapper;
import speedwagon.rick_and_morty.dto.mapper.LocationMapper;
import speedwagon.rick_and_morty.dto.mapper.MovieCharacterMapper;
import speedwagon.rick_and_morty.dto.movie_character.ApiMovieCharacterResponseDto;
import speedwagon.rick_and_morty.model.Episode;
import speedwagon.rick_and_morty.model.Location;
import speedwagon.rick_and_morty.model.MovieCharacter;
import speedwagon.rick_and_morty.service.EpisodeService;
import speedwagon.rick_and_morty.service.GeneralService;
import speedwagon.rick_and_morty.service.LocationService;
import speedwagon.rick_and_morty.service.MovieCharacterService;
import speedwagon.rick_and_morty.util.http.HttpClient;

@Service
public class GeneralServiceImpl implements GeneralService {
    private static final String CHARACTERS_URL = "https://rickandmortyapi.com/api/character";
    private static final String LOCATIONS_URL = "https://rickandmortyapi.com/api/location";
    private static final String EPISODES_URL = "https://rickandmortyapi.com/api/episode";
    private final HttpClient httpClient;
    private final MovieCharacterService movieCharacterService;
    private final EpisodeService episodeService;
    private final LocationService locationService;
    private final MovieCharacterMapper movieCharacterMapper;
    private final EpisodeMapper episodeMapper;
    private final LocationMapper locationMapper;
    private List<MovieCharacter> movieCharacters;
    private List<Episode> episodes;
    private List<Location> locations;

    public GeneralServiceImpl(HttpClient httpClient,
                              MovieCharacterService movieCharacterService,
                              EpisodeService episodeService,
                              LocationService locationService,
                              MovieCharacterMapper movieCharacterMapper,
                              EpisodeMapper episodeMapper,
                              LocationMapper locationMapper) {
        this.httpClient = httpClient;
        this.movieCharacterService = movieCharacterService;
        this.episodeService = episodeService;
        this.locationService = locationService;
        this.movieCharacterMapper = movieCharacterMapper;
        this.episodeMapper = episodeMapper;
        this.locationMapper = locationMapper;
    }

    @Override
    public void sync(String url) {
        switch (url) {
            case CHARACTERS_URL ->
                    synchronizeMovieCharacters(CHARACTERS_URL);
            case LOCATIONS_URL ->
                    synchronizeLocations(LOCATIONS_URL);
            case EPISODES_URL ->
                    synchronizeEpisodes(EPISODES_URL);
        }
    }

    @Scheduled(cron = "0 */18 * * *")
    @Override
    public void syncAll() {
        synchronizeMovieCharacters(CHARACTERS_URL);
        synchronizeEpisodes(EPISODES_URL);
        synchronizeLocations(LOCATIONS_URL);
    }

    private void synchronizeMovieCharacters(String url) {
        movieCharacters = new ArrayList<>();
        episodes = new ArrayList<>();
        locations = new ArrayList<>();
        ApiMovieCharacterResponseDto apiMovieCharacterResponseDto
                = httpClient.get(url, ApiMovieCharacterResponseDto.class);
        movieCharacters.addAll(Arrays.stream(apiMovieCharacterResponseDto.getResults())
                .map(movieCharacterMapper::toModel)
                .toList());
        while (apiMovieCharacterResponseDto.getInfo().getNext() != null) {
            String urlNext = apiMovieCharacterResponseDto.getInfo().getNext();
            apiMovieCharacterResponseDto
                    = httpClient.get(urlNext, ApiMovieCharacterResponseDto.class);
            movieCharacters.addAll(Arrays.stream(apiMovieCharacterResponseDto.getResults())
                    .map(movieCharacterMapper::toModel)
                    .toList());
        }
        locations.addAll(movieCharacters.stream()
                .map(MovieCharacter::getLocation)
                .toList());
        locations.addAll(movieCharacters.stream()
                .map(MovieCharacter::getOrigin)
                .toList());
        episodes = movieCharacters.stream()
                .map(MovieCharacter::getEpisode)
                .flatMap(Collection::stream)
                .toList();
        locations.forEach(locationService::update);
        episodes.forEach(episodeService::update);
        movieCharacters.forEach(movieCharacterService::update);
    }

    private void synchronizeEpisodes(String url) {
        episodes = new ArrayList<>();
        movieCharacters = new ArrayList<>();
        ApiEpisodeResponseDto apiEpisodeResponseDto
                = httpClient.get(url, ApiEpisodeResponseDto.class);
        episodes.addAll(Arrays.stream(apiEpisodeResponseDto.getResults())
                .map(episodeMapper::toModel)
                .toList());
        while (apiEpisodeResponseDto.getInfo().getNext() != null) {
            String urlNext = apiEpisodeResponseDto.getInfo().getNext();
            apiEpisodeResponseDto =
                    httpClient.get(urlNext, ApiEpisodeResponseDto.class);
            episodes.addAll(Arrays.stream(apiEpisodeResponseDto.getResults())
                    .map(episodeMapper::toModel)
                    .toList());
        }
        movieCharacters = episodes.stream()
                .map(Episode::getMovieCharacters)
                .flatMap(Collection::stream)
                .toList();
        movieCharacters.forEach(movieCharacterService::update);
        episodes.forEach(episodeService::update);
    }

    private void synchronizeLocations(String url) {
        locations = new ArrayList<>();
        movieCharacters = new ArrayList<>();
        ApiLocationResponseDto apiLocationResponseDto
                = httpClient.get(url, ApiLocationResponseDto.class);
        locations.addAll(Arrays.stream(apiLocationResponseDto.getResults())
                .map(locationMapper::toModel)
                .toList());
        while (apiLocationResponseDto.getInfo().getNext() != null) {
            String urlNext = apiLocationResponseDto.getInfo().getNext();
            apiLocationResponseDto =
                    httpClient.get(urlNext, ApiLocationResponseDto.class);
            locations.addAll(Arrays.stream(apiLocationResponseDto.getResults())
                    .map(locationMapper::toModel)
                    .toList());
        }
        movieCharacters = locations.stream()
                .map(Location::getResidents)
                .flatMap(Collection::stream)
                .toList();
        movieCharacters.forEach(movieCharacterService::update);
        locations.forEach(locationService::update);
    }
}
