package h_spring_data_jpa.user;

import h_spring_data_jpa.user.web.CreatedUserDto;
import h_spring_data_jpa.user.web.UpdateUserDto;
import h_spring_data_jpa.user.web.UserDto;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;


    @Override
    public CollectionModel<?> findUser() {
        List<User>users = userRepository.findAll();

        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<UserDto> findUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }

    @Override
    public User disableForUser(String uuid) {
        User disableUser = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("404 not found!!"));
        disableUser.setDelete(true);
        BeanUtils.copyProperties(disableUser,uuid);
        return userRepository.save(disableUser);
    }

    @Override
    public User CreatedUser(CreatedUserDto createdUserDto) {
        User user = UserMapper.INSTANCE.toEntity(createdUserDto);
        user.setUuid(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("404 Not found!!"));
        userRepository.delete(user);
    }

    @Override
    public User updateUserByUuid(String uuid, UpdateUserDto updateUserDto) {
        User user =   userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(updateUserDto,user,uuid);

        return userRepository.save(user);
    }
}
