package lexicon.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Column(name = "id")
    private Integer id;

    @Column (nullable = false, unique = true)
    @Setter
    private String email;

    @Column (nullable = false, length = 20)
    @Setter
    private String name;

    @Column
    private LocalDate birthDate;

   /* @OneToOne(mappedBy = "details")
    private AppUser appUser;

    */


}
