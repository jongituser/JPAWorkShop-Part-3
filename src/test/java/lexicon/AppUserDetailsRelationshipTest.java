package lexicon;

import lexicon.entity.AppUser;
import lexicon.entity.Details;
import lexicon.repository.AppUserRepository;
import lexicon.repository.DetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AppUserDetailsRelationshipTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    private AppUser appUser;
    private Details details;

    @BeforeEach
    public void setUp() {
        // Create and save details
        details = new Details();
        details.setEmail("test@example.com");
        details.setName("John Doe");

        // Create and save a user with those details
        appUser = new AppUser();
        appUser.setUsername("johndoe");
        appUser.setPassword("password123");

        // Set the bidirectional relationship
        appUser.setDetails(details);  // Link details to user
        details.setAppUser(appUser);  // Link user to details

        appUserRepository.save(appUser);  // Save user, which cascades and saves details
    }

    @Test
    public void testOneToOneAppUserAndDetails() {
        // Fetch the user and verify the details
        AppUser foundUser = appUserRepository.findById(appUser.getId()).get();
        assertThat(foundUser.getDetails().getEmail()).isEqualTo("test@example.com");

        // Fetch the details and verify the user
        Details foundDetails = detailsRepository.findById(details.getId()).get();
        assertThat(foundDetails.getAppUser().getUsername()).isEqualTo("johndoe");
    }
}
