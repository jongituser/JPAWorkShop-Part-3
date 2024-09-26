package lexicon.se.repository;
import lexicon.se.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author, Integer> {
    
}
