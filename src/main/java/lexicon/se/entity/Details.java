package lexicon.se.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Details {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique = true)
    @Setter
    private String email;

    @Column (nullable = false, length = 20)
    @Setter
    private String name;

    @Column
    private LocalDate birthDate;

    @OneToOne (mappedBy = "id")
    private AppUser userid;

}
