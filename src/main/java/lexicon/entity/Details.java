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
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @Setter
    private String email;

    @Column
    @Setter
    private String name;

    @Column
    private LocalDate birthDate;

   /* @OneToOne(mappedBy = "details")
    private AppUser appUser;

    */


}
