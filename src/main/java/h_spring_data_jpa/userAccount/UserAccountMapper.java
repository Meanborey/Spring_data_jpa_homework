package h_spring_data_jpa.userAccount;


import h_spring_data_jpa.userAccount.web.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);
    UserAccountDto mapUserAccountToUserAccountDto(UserAccount userAccount);

    List<UserAccountDto> mapListUserAccountToListUserAccount(List<UserAccount> userAccounts);
}
