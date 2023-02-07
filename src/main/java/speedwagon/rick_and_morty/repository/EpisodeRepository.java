package speedwagon.rick_and_morty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedwagon.rick_and_morty.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
