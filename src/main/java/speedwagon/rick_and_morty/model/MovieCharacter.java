package speedwagon.rick_and_morty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import speedwagon.rick_and_morty.model.enums.Gender;
import speedwagon.rick_and_morty.model.enums.Status;

@Data
@Entity
@Table(name = "movie_character")
public class MovieCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String species;
    private String type;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private Location origin;
    @ManyToOne
    private Location location;
    private String image;
    @ManyToMany
    private List<Episode> episode;
    private String url;
    private String created;
}
