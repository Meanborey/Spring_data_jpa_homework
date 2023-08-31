package h_spring_data_jpa.account;

import h_spring_data_jpa.account_type.Account_type;
import h_spring_data_jpa.userAccount.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String uuid;

    @Column(name = "act_name")
    private String actName;

    @Column(name = "act_no")
    private String actNo;

    @Column(name = "transfer_limit")
    private BigDecimal transferLimit;

    private BigDecimal balance;

    private String pin;


    @OneToMany(mappedBy = "account")
    private List<UserAccount>userAccounts;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private Account_type account_type;


}
