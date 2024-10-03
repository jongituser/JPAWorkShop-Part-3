package lexicon;

import lexicon.entity.Author;
import lexicon.entity.Book;
import lexicon.repository.AuthorRepository;
import lexicon.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorBookRelationshipTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    private Author author;
    private Book book;

    @BeforeEach
    public void setUp() {


        book = new Book();
        book.setIsbn("123456789");
        book.setTitle("Test Book");
        book.setMaxLoanDays(30);


        author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");


        Set<Book> writtenBooks = new HashSet<>();
        writtenBooks.add(book);
        author.setWrittenBooks(writtenBooks);

        Set<Author> authors = new HashSet<>();
        authors.add(author);
        book.setAuthors(authors);

        bookRepository.save(book);
        authorRepository.save(author);
    }

    @Test
    @Transactional
    public void testSaveAndRetrieveAuthorBookRelationship() {

        Author foundAuthor = authorRepository.findById(author.getId()).get();

        assertThat(foundAuthor).isNotNull();
        assertThat(foundAuthor.getWrittenBooks()).hasSize(1);
        assertThat(foundAuthor.getWrittenBooks().iterator().next().getTitle()).isEqualTo("Test Book");


        Book foundBook = bookRepository.findById(book.getId()).get();


        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getAuthors()).hasSize(1);
        assertThat(foundBook.getAuthors().iterator().next().getFirstName()).isEqualTo("John");
    }
}
