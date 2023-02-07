package speedwagon.rick_and_morty.service.impl;

import org.springframework.stereotype.Service;
import speedwagon.rick_and_morty.model.Location;
import speedwagon.rick_and_morty.repository.LocationRepository;
import speedwagon.rick_and_morty.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location get(Long id) {
        return locationRepository.getReferenceById(id);
    }

    @Override
    public Location update(Location location) {
        return locationRepository.save(location);
    }
}
