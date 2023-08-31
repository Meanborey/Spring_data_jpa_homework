package h_spring_data_jpa.role;

import h_spring_data_jpa.authority.Authority;
import h_spring_data_jpa.userRole.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole>userRoles;

    @ManyToMany(mappedBy = "roles")
    private List<Authority>authorities;

}
