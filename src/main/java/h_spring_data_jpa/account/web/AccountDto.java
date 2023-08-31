package h_spring_data_jpa.account.web;


import h_spring_data_jpa.account_type.Account_type;
import h_spring_data_jpa.userAccount.UserAccount;
import jakarta.validation.constraints.Min;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
@Builder
public record AccountDto(


        String actName,
        String actNo,
        String pin,
        BigDecimal transferLimit,
        BigDecimal balance,
        String uuid,
        List<UserAccount> userAccounts,
        Account_type account_type
) {
}
