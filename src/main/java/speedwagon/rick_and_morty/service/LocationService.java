package speedwagon.rick_and_morty.service;

import speedwagon.rick_and_morty.model.Location;

public interface LocationService {
    Location save(Location location);

    Location get(Long id);

    Location update(Location location);
}
