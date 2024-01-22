package soft.musala.userservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import soft.musala.userservice.model.CreateUserResponse;
import soft.musala.userservice.model.CreateUserRequest;
import soft.musala.userservice.model.UserEntity;
import soft.musala.userservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {


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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByEmail(username);
        if(userEntity.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userEntity.get().getEmail(), userEntity.get().getEncryptedPassword(),
                true, true, true, true, new ArrayList<>());
    }

    public String getUserIdByEmail(String username) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(username);
        if(userEntity.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return userEntity.get().getUserId();
    }
}
