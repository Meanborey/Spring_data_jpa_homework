package h_spring_data_jpa.user;

import h_spring_data_jpa.user.web.CreatedUserDto;
import h_spring_data_jpa.user.web.UpdateUserDto;
import h_spring_data_jpa.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;


public interface UserService {
    CollectionModel<?> findUser();

    EntityModel<UserDto> findUserByUuid(String uuid);

    User disableForUser(String uuid);

    User CreatedUser(CreatedUserDto createdUserDto);

    void deleteUserByUuid(String uuid);

    User updateUserByUuid(String uuid, UpdateUserDto updateUserDto);

}
