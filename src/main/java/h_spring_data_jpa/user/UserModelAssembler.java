package h_spring_data_jpa.user;

import h_spring_data_jpa.account.web.AccountController;
import h_spring_data_jpa.user.User;
import h_spring_data_jpa.user.web.UserController;
import h_spring_data_jpa.user.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Configuration
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {


    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @SuppressWarnings("unchecked")
    public UserModelAssembler() {
        super(UserController.class, (Class<EntityModel<UserDto>>) (Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<UserDto> toModel(User entity) {
        UserDto userDto = userMapper.mapUserToUserDto(entity);
        Link link = linkTo(methodOn(UserController.class).findUserByUuid(entity.getUuid())).withSelfRel();
        Link link1 = linkTo(methodOn(UserController.class).findUser()).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(userDto,link,link1);
    }
}
