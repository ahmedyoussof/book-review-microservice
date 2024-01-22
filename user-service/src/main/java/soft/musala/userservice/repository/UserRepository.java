package soft.musala.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import soft.musala.userservice.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
