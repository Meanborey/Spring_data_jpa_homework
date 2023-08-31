package h_spring_data_jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

//    List<User>findByDeleteFalse();

    Optional<User>findByUuid(String uuid);
}
