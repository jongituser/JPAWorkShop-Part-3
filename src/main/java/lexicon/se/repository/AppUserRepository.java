package lexicon.se.repository;
import lexicon.se.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

}
