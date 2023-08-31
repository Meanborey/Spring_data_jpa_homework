package h_spring_data_jpa.user.web;

import h_spring_data_jpa.base.BaseApi;
import h_spring_data_jpa.user.User;
import h_spring_data_jpa.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("")
    public BaseApi<?> createUser(@RequestBody CreatedUserDto createdUserDto) {

        User user = userService.CreatedUser(createdUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("successful")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("users")
    public CollectionModel<?>findUser(){
        return userService.findUser();
    }


    @PutMapping("/update/{uuid}")
    public BaseApi<?> updateUser(@RequestBody UpdateUserDto createUserDto,@PathVariable("uuid") String uuid) {

        User user = userService.updateUserByUuid(uuid,createUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("successful")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findUserByUuid(@PathVariable String uuid){
        return userService.findUserByUuid(uuid);
    }

    @PutMapping("/{uuid}/disable")
    public ResponseEntity<User>disableUserByUuid(@PathVariable String uuid){
        User user = userService.disableForUser(uuid);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{uuid}")
    public BaseApi<?> deleteUserByUuid(@PathVariable("uuid") String uuid) {
        userService.deleteUserByUuid(uuid);


        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data("your uuid delete : "+uuid)
                .message("successful")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .build();
    }


}
