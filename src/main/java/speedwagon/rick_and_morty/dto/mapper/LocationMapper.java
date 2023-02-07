package speedwagon.rick_and_morty.dto.mapper;

import org.springframework.stereotype.Component;
import speedwagon.rick_and_morty.dto.location.ApiLocationDto;
import speedwagon.rick_and_morty.model.Location;
import speedwagon.rick_and_morty.model.MovieCharacter;

@Component
public class LocationMapper {
    public Location toModel(ApiLocationDto apiLocationDto) {
        Location location = new Location();
        location.setId(apiLocationDto.getId());
        location.setName(apiLocationDto.getName());
        location.setType(apiLocationDto.getType());
        location.setDimension(apiLocationDto.getDimension());
        location.setResidents(apiLocationDto.getResidents()
                .stream()
                .map(this::setMovieCharactersUrl)
                .toList());
        location.setUrl(apiLocationDto.getUrl());
        location.setCreated(apiLocationDto.getCreated());
        return location;
    }

    private MovieCharacter setMovieCharactersUrl(String url) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setUrl(url);
        return movieCharacter;
    }
}
