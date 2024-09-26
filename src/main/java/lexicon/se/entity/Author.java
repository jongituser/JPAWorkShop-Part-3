package lexicon.se.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "author_book",  // Join table name
            joinColumns = @JoinColumn(name = "author_id"),  // Foreign key in join table pointing to Author
            inverseJoinColumns = @JoinColumn(name = "book_id")  // Foreign key in join table pointing to Book
    )
    private Set<Book> writtenBooks = new HashSet<>();
}
