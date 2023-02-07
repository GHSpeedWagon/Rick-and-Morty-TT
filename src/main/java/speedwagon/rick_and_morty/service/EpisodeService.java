package speedwagon.rick_and_morty.service;

import java.util.List;
import speedwagon.rick_and_morty.model.Episode;

public interface EpisodeService {
    Episode save(Episode episode);

    String saveAll(List<Episode> episodes);

    Episode get(Long id);

    void update(Episode episode);

    void delete(Long id);
}
