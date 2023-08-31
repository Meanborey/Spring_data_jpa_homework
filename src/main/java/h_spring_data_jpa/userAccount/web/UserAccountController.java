package h_spring_data_jpa.userAccount.web;


import h_spring_data_jpa.userAccount.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/userAccounts")
public class UserAccountController {
    private final UserAccountService userAccountService;
    @GetMapping("/user-account")
    public CollectionModel<?> findUserAccount() {
        return userAccountService.findAllUserAccount();
    }

    @GetMapping("/{id}")
    public EntityModel<?> findUserAccountById(@PathVariable("id") int id) {
        return userAccountService.findByIdUserAccount(id);
    }


}
