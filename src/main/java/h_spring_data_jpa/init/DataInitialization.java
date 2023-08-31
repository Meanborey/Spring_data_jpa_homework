package h_spring_data_jpa.init;

import h_spring_data_jpa.account.Account;
import h_spring_data_jpa.account.AccountRepository;
import h_spring_data_jpa.transaction.Transaction;
import h_spring_data_jpa.transaction.TransactionRepository;
import h_spring_data_jpa.user.User;
import h_spring_data_jpa.user.UserRepository;
import h_spring_data_jpa.userAccount.UserAccount;
import h_spring_data_jpa.userAccount.UserAccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final UserAccountRepository userAccountRepository;
    private final TransactionRepository transactionRepository;


    @PostConstruct
    void init(){

        User user = User.builder()
                .email("sinmeanborey11@gmail.com")
                .name("Borey")
                .password(String.valueOf(UUID.randomUUID()))
                .isStudent(true)
                .isDelete(false)
                .phoneNumber("081799639")
                .uuid(String.valueOf(UUID.randomUUID()))
                .build();
        User user1 = User.builder()
                .email("sinmean02@gmail.com")
                .name("Mean")
                .password(String.valueOf(UUID.randomUUID()))
                .isStudent(true)
                .isDelete(false)
                .phoneNumber("017880979")
                .uuid(String.valueOf(UUID.randomUUID()))
                .build();
        User user2 = User.builder()
                .email("sopheapsiv99@gmail.com")
                .name("Sopheap")
                .password(String.valueOf(UUID.randomUUID()))
                .isStudent(true)
                .isDelete(false)
                .phoneNumber("012231295")
                .uuid(String.valueOf(UUID.randomUUID()))
                .build();
        User user3 = User.builder()
                .email("sinsivmey22@gmail.com")
                .name("mey")
                .password(String.valueOf(UUID.randomUUID()))
                .isStudent(true)
                .isDelete(false)
                .phoneNumber("081595755")
                .uuid(String.valueOf(UUID.randomUUID()))
                .build();

        userRepository.saveAll(List.of(user,user1,user2,user3));

        Account account = Account.builder()
                .actName("Borey")
                .actNo("172212")
                .pin("323445")
                .transferLimit(BigDecimal.valueOf(2000))
                .balance(BigDecimal.valueOf(1000))
                .uuid(UUID.randomUUID().toString())
                .build();
        Account account1 = Account.builder()
                .actName("Mean")
                .actNo("172212")
                .pin("323445")
                .transferLimit(BigDecimal.valueOf(10000))
                .balance(BigDecimal.valueOf(2000))
                .uuid(UUID.randomUUID().toString())
                .build();
        Account account2 = Account.builder()
                .actName("Sopheap")
                .actNo("172212")
                .pin("323445")
                .transferLimit(BigDecimal.valueOf(30000))
                .balance(BigDecimal.valueOf(2000))
                .uuid(UUID.randomUUID().toString())
                .build();
        Account account3 = Account.builder()
                .actName("mey")
                .actNo("172212")
                .pin("323445")
                .transferLimit(BigDecimal.valueOf(3000))
                .balance(BigDecimal.valueOf(3000))
                .uuid(UUID.randomUUID().toString())
                .build();
        //Save account
        accountRepository.saveAll(List.of(account,account1,account2,account3));


        UserAccount userAccount = UserAccount.builder()
                                .user(user)
                                .account(account)
                                .isDisabled(true).build();
        UserAccount userAccount2 = UserAccount.builder()
                                    .isDisabled(true)
                                    .build();
        UserAccount userAccount3 = UserAccount.builder()
                                    .isDisabled(true)
                                    .build();
        UserAccount userAccount4 = UserAccount.builder()
                                    .isDisabled(true)
                                    .build();
        UserAccount userAccount5 = UserAccount.builder()
                                    .isDisabled(true)
                                    .build();
       userAccountRepository.saveAll(List.of(userAccount,userAccount2,userAccount3,userAccount4,userAccount5));

        Transaction transaction = Transaction.builder()
                .transactionAt(LocalDateTime.now())
                .amount(2000L)
                .uuid(UUID.randomUUID().toString())
                .remark("transfer successfully")
                .studentCardNo("2334ffd")
                .build();
        Transaction transaction2 = Transaction.builder()
                .transactionAt(LocalDateTime.now())
                .amount(2000L)
                .uuid(UUID.randomUUID().toString())
                .remark("transfer successfully")
                .studentCardNo("2334ffd")
                .build();
        Transaction transaction3 = Transaction.builder()
                .transactionAt(LocalDateTime.now())
                .amount(2000L)
                .uuid(UUID.randomUUID().toString())
                .remark("transfer successfully")
                .studentCardNo("2334ffd")
                .build();
        Transaction transaction4 = Transaction.builder()
                .transactionAt(LocalDateTime.now())
                .amount(2000L)
                .uuid(UUID.randomUUID().toString())
                .remark("transfer successfully")
                .studentCardNo("2334ffd")
                .build();
       transactionRepository.saveAll(List.of(transaction,transaction2,transaction3,transaction4));

    }

}
