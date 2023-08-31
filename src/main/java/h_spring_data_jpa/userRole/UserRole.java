package h_spring_data_jpa.userRole;

import h_spring_data_jpa.role.Role;
import h_spring_data_jpa.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "users_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "create_at")
    private Calendar createdAt;

    @Column(name = "update_at")
    private Calendar updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
