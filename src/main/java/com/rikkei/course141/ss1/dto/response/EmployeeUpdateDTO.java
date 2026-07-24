package com.rikkei.course141.ss1.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmployeeUpdateDTO {
    @NotBlank @Size(min = 5) private String fullName;
    @NotBlank @Email private String email;
    @NotBlank private String department;
    private MultipartFile avatarFile;
}
