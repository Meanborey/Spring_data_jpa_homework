package h_spring_data_jpa.transaction;

import h_spring_data_jpa.account.Account;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "transactios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String uuid;

    private Long amount;

    @Column(name = "is_payment")
    private boolean isPayment;

    @CreatedDate
    @Column(name = "transaction_at")
    private LocalDateTime transactionAt;

    private String remark;

    @Column(name = "student_card_no")
    private String studentCardNo;

    @ManyToOne
    @JoinColumn(name = "receiver_act_id")
    private Account receiverAccount;

    @ManyToOne
    @JoinColumn(name = "sender_act_id")
    private Account senderAccount;

}
