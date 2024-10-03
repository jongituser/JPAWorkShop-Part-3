package lexicon;

import lexicon.entity.Book;
import lexicon.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    public void testSaveBook() {
        // Create a new book instance
        Book book = new Book();
        book.setIsbn("987654321");
        book.setTitle("Test Book Title");
        book.setMaxLoanDays(30);


        Book savedBook = bookRepository.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("Test Book Title");
        assertThat(savedBook.getIsbn()).isEqualTo("987654321");
        assertThat(savedBook.getMaxLoanDays()).isEqualTo(30);
    }
}