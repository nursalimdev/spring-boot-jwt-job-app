package nursalim.springboot.jwt.jobapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
