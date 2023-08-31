package h_spring_data_jpa.account;


import h_spring_data_jpa.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    EntityModel<?> findByUuidAccount(String uuid);
    CollectionModel<?> findAllAccount();
    Account disableAccount(String uuid);
    Account CreateAccount(CreateAccountDto createAccountDto);





}
