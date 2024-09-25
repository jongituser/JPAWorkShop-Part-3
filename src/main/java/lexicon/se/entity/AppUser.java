package lexicon.se.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Entity

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class AppUser {

    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique = true)
    @Setter
    private String username;

    @Column
    @Setter
    private String password;

    @Column
    private LocalTime regDate;

    @Setter
    @OneToOne (mappedBy = "id", cascade = CascadeType.ALL)
    private Details userDetails;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    private Set<BookLoan> bookLoans = new HashSet<>();

}
