package h_spring_data_jpa.account.web;


import h_spring_data_jpa.account.Account;
import h_spring_data_jpa.account.AccountService;
import h_spring_data_jpa.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;
    @GetMapping
    public CollectionModel<?> findAccount() {
        return accountService.findAllAccount();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findAccountById(@PathVariable("uuid") String uuid) {
        return accountService.findByUuidAccount(uuid);
    }

    @PutMapping("/{uuid}/close")
    public ResponseEntity<?> disableAccountByUuid(@PathVariable String uuid) {
        Account account = accountService.disableAccount(uuid);
        return ResponseEntity.ok(account);
    }

    @PostMapping("")
    public BaseApi<?> createUser(@RequestBody CreateAccountDto createAccountDto) {

       Account account = accountService.CreateAccount(createAccountDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(account)
                .message("successful")
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
