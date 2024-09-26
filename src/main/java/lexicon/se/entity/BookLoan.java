package lexicon.se.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "book_loan")
public class BookLoan {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate loanDate;

    @Column
    private LocalDate dueDate;

    @Column
    private boolean returned;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    private AppUser borrower;

    @ManyToOne
    @JoinColumn(name = ("book_id"))
    private Book book;

    
}
