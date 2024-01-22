package soft.musala.userservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import soft.musala.userservice.model.CreateUserResponse;
import soft.musala.userservice.model.CreateUserRequest;
import soft.musala.userservice.model.UserEntity;
import soft.musala.userservice.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {


    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        createUserRequest.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(createUserRequest, UserEntity.class);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword()));
        userRepository.save(userEntity);



        return modelMapper.map(userEntity, CreateUserResponse.class);
    }

}
