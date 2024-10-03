package lexicon;

import lexicon.entity.Book;
import lexicon.entity.BookLoan;
import lexicon.repository.BookLoanRepository;
import lexicon.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookLoanBookRelationshipTest {

    @Autowired
    private BookLoanRepository bookLoanRepository;

    @Autowired
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    public void setUp() {
        // Create and save a book
        book = new Book();
        book.setIsbn("987654321");
        book.setTitle("Book Loan Test");
        book.setMaxLoanDays(14);
        bookRepository.save(book);

        // Create and save two book loans for the same book
        BookLoan loan1 = new BookLoan();
        loan1.setLoanDate(LocalDate.now());
        loan1.setDueDate(LocalDate.now().plusDays(14));
        loan1.setBook(book);
        bookLoanRepository.save(loan1);

        BookLoan loan2 = new BookLoan();
        loan2.setLoanDate(LocalDate.now());
        loan2.setDueDate(LocalDate.now().plusDays(14));
        loan2.setBook(book);
        bookLoanRepository.save(loan2);
    }

    @Test
    public void testManyToOneBookLoanToBook() {
        // Verify that the book has been loaned twice
        assertThat(bookLoanRepository.findByBook_Id(book.getId()).size()).isEqualTo(2);
    }
}
