package h_spring_data_jpa.account;

import h_spring_data_jpa.account.web.AccountController;
import h_spring_data_jpa.account.web.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
@Configuration
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {

    private AccountMapper accountMapper;
    @Autowired
    public void setAccountMapper(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    @SuppressWarnings("unchecked")
    public AccountModelAssembler() {
        super(AccountController.class, (Class<EntityModel<AccountDto>>)(Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapper.mapAccountToAccountDto(entity);
        Link link = linkTo(methodOn(AccountController.class).findAccountById(entity.getUuid())).withSelfRel();
        Link link1 = linkTo(methodOn(AccountController.class).findAccount()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(accountDto,link,link1);
    }

    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }
}
