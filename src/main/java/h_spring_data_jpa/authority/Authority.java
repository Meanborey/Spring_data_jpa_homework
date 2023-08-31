package h_spring_data_jpa.authority;

import h_spring_data_jpa.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "authorites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    private List<Role>roles;
}
