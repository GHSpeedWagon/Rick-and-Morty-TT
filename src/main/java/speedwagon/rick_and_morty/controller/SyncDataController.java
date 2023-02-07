package speedwagon.rick_and_morty.controller;

import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speedwagon.rick_and_morty.service.GeneralService;

@RestController
@RequestMapping("/movie/rick-and-morty/sync")
public class SyncDataController {
    private static final String CHARACTERS_URL = "https://rickandmortyapi.com/api/character";
    private static final String LOCATIONS_URL = "https://rickandmortyapi.com/api/location";
    private static final String EPISODES_URL = "https://rickandmortyapi.com/api/episode";
    private static Map<String, String> parseValue_url;
    private final GeneralService generalService;

    static {
        parseValue_url = new HashMap<>();
        parseValue_url.put("characters", CHARACTERS_URL);
        parseValue_url.put("locations", LOCATIONS_URL);
        parseValue_url.put("episodes", EPISODES_URL);
    }

    public SyncDataController(GeneralService generalService) {
        this.generalService = generalService;
    }

    @ApiOperation(value =
            "sync data from api to db (characters, locations, episodes, all) - all is default"
    )
    @GetMapping()
    public String sync(@PathVariable(required = false) String type) {
        if (type != null && parseValue_url.containsKey(type)) {
            generalService.sync(parseValue_url.get(type));
            return type + " collected";
        } else if (type == null || Objects.equals(type, "all")) {
            generalService.syncAll();
            return "all data collected to db";
        }
        return "cant find link by value=" + type;
    }
}
