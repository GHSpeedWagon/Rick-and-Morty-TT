package speedwagon.rick_and_morty.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import speedwagon.rick_and_morty.model.Episode;
import speedwagon.rick_and_morty.repository.EpisodeRepository;
import speedwagon.rick_and_morty.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Episode save(Episode episode) {
        return episodeRepository.save(episode);
    }

    @Override
    public String saveAll(List<Episode> episodes) {
        episodeRepository.saveAll(episodes);
        return "List of episodes was saved";
    }

    @Override
    public Episode get(Long id) {
        return episodeRepository.getReferenceById(id);
    }

    @Override
    public void update(Episode episode) {
        episodeRepository.save(episode);
    }

    @Override
    public void delete(Long id) {
        episodeRepository.deleteById(id);
    }
}
