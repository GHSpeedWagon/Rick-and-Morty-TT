package speedwagon.rick_and_morty.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import speedwagon.rick_and_morty.model.MovieCharacter;

@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {
    List<MovieCharacter> getAllByNameContains(String name);

    @Query("SELECT id from MovieCharacter order by id desc limit 1")
    Long findMaxId();
}
