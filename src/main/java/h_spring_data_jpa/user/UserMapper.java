package h_spring_data_jpa.user;

import h_spring_data_jpa.user.web.CreatedUserDto;
import h_spring_data_jpa.user.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
   UserMapper INSTANCE =Mappers.getMapper(UserMapper.class);
   User toEntity(CreatedUserDto createdUserDto);
    UserDto mapUserToUserDto(User user);

}
