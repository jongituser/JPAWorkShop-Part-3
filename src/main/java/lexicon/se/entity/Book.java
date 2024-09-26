package lexicon.se.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String isbn;

    @Column
    private String title;

    @Column
    private int maxLoanDays;

    @ManyToMany(mappedBy = "writtenBooks")
    private Set<Author> authors = new HashSet<>();

}