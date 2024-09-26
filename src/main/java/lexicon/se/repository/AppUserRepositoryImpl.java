package lexicon.se.repository;
import lexicon.se.entity.AppUser;
import java.util.Optional;

public class AppUserRepositoryImpl implements AppUserRepository {
    @Override
    public <S extends AppUser> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AppUser> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AppUser> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<AppUser> findAll() {
        return null;
    }

    @Override
    public Iterable<AppUser> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(AppUser entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends AppUser> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
