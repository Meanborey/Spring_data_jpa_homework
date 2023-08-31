package h_spring_data_jpa.account.web;



import h_spring_data_jpa.account_type.Account_type;
import h_spring_data_jpa.userAccount.UserAccount;

import java.math.BigDecimal;
import java.util.List;

public record CreateAccountDto(
        int id,
        String actName,
        String actNo,
        BigDecimal transferLimit,
        BigDecimal balance,
        String pin,
        String uuid,
        List<UserAccount> userAccounts,
        Account_type account_type
) {
}
