package h_spring_data_jpa.userAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService{
    private final UserAccountRepository accountRepository;
    private final UserAccountModelAssembler userAccountModelAssembler;
    @Override
    public EntityModel<?> findByIdUserAccount(int id) {
        UserAccount user = accountRepository.findById(id).orElseThrow();
        return userAccountModelAssembler.toModel(user);
    }

    @Override
    public CollectionModel<?> findAllUserAccount() {
        List<UserAccount> userAccounts  = accountRepository.findAll();
        return userAccountModelAssembler.toCollectionModel(userAccounts);
    }
}
