package lexicon.se.repository;
import lexicon.se.entity.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BookDao extends CrudRepository<Book, Integer> {


    Book findByIsbnIgnoreCase(String isbn);


    List<Book> findByTitleContainingIgnoreCase(String title);


    List<Book> findByMaxLoanDaysLessThan(int maxLoanDays);

}