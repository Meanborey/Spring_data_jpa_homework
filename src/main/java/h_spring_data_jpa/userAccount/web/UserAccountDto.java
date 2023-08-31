package h_spring_data_jpa.userAccount.web;


import h_spring_data_jpa.account.Account;
import h_spring_data_jpa.user.User;

public record UserAccountDto(
        int id,
        Boolean isDisabled,
        User user,
        Account account
) {

}
