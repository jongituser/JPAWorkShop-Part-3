package lexicon.se.repository;

import lexicon.se.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book();
        book1.setIsbn("1234567890");
        book1.setTitle("Java Programming");
        book1.setMaxLoanDays(14);

        book2 = new Book();
        book2.setIsbn("0987654321");
        book2.setTitle("Spring Framework");
        book2.setMaxLoanDays(7);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }

    @Test
    void testFindByIsbnIgnoreCase() {
        List<Book> books = bookRepository.findByIsbnIgnoreCase("1234567890");
        assertThat(books).containsExactly(book1);

        books = bookRepository.findByIsbnIgnoreCase("1234567890".toLowerCase());
        assertThat(books).containsExactly(book1);
    }

    @Test
    void testFindByTitleContainingIgnoreCase() {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase("Java");
        assertThat(books).containsExactly(book1);

        books = bookRepository.findByTitleContainingIgnoreCase("framework");
        assertThat(books).containsExactly(book2);

        books = bookRepository.findByTitleContainingIgnoreCase("gram");
        assertThat(books).containsExactlyInAnyOrder(book1, book2);
    }

    @Test
    void testFindBooksByMaxLoanDaysLessThan() {
        List<Book> books = bookRepository.findBooksByMaxLoanDaysLessThan(10);
        assertThat(books).containsExactly(book2);

        books = bookRepository.findBooksByMaxLoanDaysLessThan(15);
        assertThat(books).containsExactlyInAnyOrder(book1, book2);
    }
}
