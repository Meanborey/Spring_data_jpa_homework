package h_spring_data_jpa.userAccount;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface UserAccountService {
    EntityModel<?> findByIdUserAccount(int id);
    CollectionModel<?> findAllUserAccount();
}
