package lexicon;
import lexicon.entity.Book;
import lexicon.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryImplTest {

    @Autowired
    private BookRepository BookRepository;

    @Test
    public void testSaveBookPermanently() {

        Book book = new Book();
        book.setIsbn("987654321");
        book.setTitle("Another Permanent Book");
        book.setMaxLoanDays(60);

        Book savedBook = BookRepository.saveAndFlush(book);
    }
}
