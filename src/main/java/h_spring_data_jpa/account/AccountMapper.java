package h_spring_data_jpa.account;

import h_spring_data_jpa.account.web.AccountDto;
import h_spring_data_jpa.account.web.CreateAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    AccountDto mapAccountToAccountDto(Account account);
    List<AccountDto> mapListAccountToListAccountDto(List<Account> accounts);
    Account accountToCreateAccount(CreateAccountDto createAccountDto);
}
