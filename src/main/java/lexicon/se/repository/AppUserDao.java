package lexicon.se.repository;
import lexicon.se.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserDao extends CrudRepository<AppUser, Integer> {

}
