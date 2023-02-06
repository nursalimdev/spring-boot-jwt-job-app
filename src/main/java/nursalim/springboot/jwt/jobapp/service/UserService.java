package nursalim.springboot.jwt.jobapp.service;

import nursalim.springboot.jwt.jobapp.dto.UserDto;
import nursalim.springboot.jwt.jobapp.entity.User;
import nursalim.springboot.jwt.jobapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public void login(UserDto userDto){
        // query by username and password
        User user = userRepository.findByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        Optional.ofNullable(user)
                .orElseThrow(() -> new IllegalArgumentException("Username or password is wrong"));

    }

    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}
