package lexicon.se.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String writtenBook;

    @OneToMany (mappedBy = "author")
    private Set<Book> books = new HashSet<>();


}
