package lexicon.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    @Setter
    private String username;

    @Column
    @Setter
    private String password;

    @Column
    private LocalTime regDate;

   /* @OneToOne
    @JoinColumn(name = "details_id")
    private Details details;

    @OneToMany(mappedBy = "borrower")
    private Set<BookLoan> bookLoans = new HashSet<>();*/

}