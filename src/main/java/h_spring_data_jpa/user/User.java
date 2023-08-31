package h_spring_data_jpa.user;

import h_spring_data_jpa.userAccount.UserAccount;
import h_spring_data_jpa.userRole.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String uuid;

    @Column(name = "is_delete")
    private boolean isDelete;

    @Column(name = "is_student")
    private boolean isStudent;

    @Column(name = "is_verified")
    private boolean isVerified;

    private String email;

    private String name;

    private String gender;

    @Column(name = "one_signal_id")
    private String oneSignalId;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "student_card_no")
    private String studentCardNo;

    @Column(name = "verified_code")
    private String verifiedCode;

    @OneToMany(mappedBy = "user")
    private List<UserAccount> userAccounts;

    @OneToMany(mappedBy = "user")
    private List<UserRole>userRoles;

}
