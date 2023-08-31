package h_spring_data_jpa.account_type;

import h_spring_data_jpa.account.Account;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "account_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "account_type")
    private List<Account>accounts;

}
