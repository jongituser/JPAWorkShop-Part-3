package lexicon.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Setter
    @Column(name = "isbn", nullable = false, updatable = false)
    private String isbn;

    @Setter
    @Column(name = "max_loan_days", nullable = false)
    private int maxLoanDays;

    @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany(mappedBy = "writtenBooks")
    private Set<Author> authors;

}