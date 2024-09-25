package lexicon.se.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Book {

    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String isbn;

    @Column
    private String title;

    @Column
    private int maxLoanDays;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookLoan> bookLoans = new HashSet<>();
}
