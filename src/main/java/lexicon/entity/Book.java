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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Setter
    @Column
    private String isbn;

    @Setter
    @Column
    private int maxLoanDays;

    @Setter
    @Column
    private String title;

    /*
    @ManyToMany(mappedBy = "writtenBooks")
    private Set<Author> authors;


     */
}