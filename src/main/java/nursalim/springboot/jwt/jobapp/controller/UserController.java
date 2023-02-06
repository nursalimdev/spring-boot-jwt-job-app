package nursalim.springboot.jwt.jobapp.controller;

import nursalim.springboot.jwt.jobapp.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/")
public class UserController {
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        return new ResponseEntity<>("Register success",HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
        return new ResponseEntity<>("Login success",HttpStatus.OK);
    }
}
