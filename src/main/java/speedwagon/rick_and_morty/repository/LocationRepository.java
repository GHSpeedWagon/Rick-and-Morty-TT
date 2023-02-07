package speedwagon.rick_and_morty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedwagon.rick_and_morty.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
