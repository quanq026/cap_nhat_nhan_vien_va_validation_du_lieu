package com.rikkei.course141.ss1.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmployeeCreateDTO {
    @NotBlank private String fullName;
    @NotBlank private String email;
    @NotBlank private String department;
    private MultipartFile avatarFile;
}
