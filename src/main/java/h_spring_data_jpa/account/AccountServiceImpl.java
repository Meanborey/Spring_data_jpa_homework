package h_spring_data_jpa.account;


import h_spring_data_jpa.account.web.CreateAccountDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountModelAssembler accountModelAssembler;
    private final AccountRepository accountRepository;
    @Override
    public EntityModel<?> findByUuidAccount(String uuid) {
        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        return accountModelAssembler.toModel(account);
    }

    @Override
    public CollectionModel<?> findAllAccount() {
        List<Account> accounts  = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);
    }

    @Override
    public Account disableAccount(String uuid) {
        Account existingUser = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));


        BeanUtils.copyProperties(existingUser,uuid);
        return accountRepository.save(existingUser);    }

    @Override
    public Account CreateAccount(CreateAccountDto createAccountDto) {
        Account account =  AccountMapper.INSTANCE.accountToCreateAccount(createAccountDto);
        account.setUuid(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }


}
