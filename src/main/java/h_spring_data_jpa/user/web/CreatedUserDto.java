package h_spring_data_jpa.user.web;

import h_spring_data_jpa.userAccount.UserAccount;
import h_spring_data_jpa.userRole.UserRole;
import lombok.Builder;

import java.util.List;

@Builder
public record CreatedUserDto(
        int id,
        String uuid,
        String name,
        String password,
        String email,
        String phoneNumber,
        Boolean isDelete,
        Boolean isStudent,
        Boolean isVerified,
        List<UserAccount> userAccounts,
        List<UserRole> userRoles
) {
}
