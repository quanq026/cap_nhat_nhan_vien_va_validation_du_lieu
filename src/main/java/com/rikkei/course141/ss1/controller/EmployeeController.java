package com.rikkei.course141.ss1.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import com.rikkei.course141.ss1.dto.response.ApiResponse;
import com.rikkei.course141.ss1.dto.response.EmployeeUpdateDTO;
import com.rikkei.course141.ss1.model.Employee;
import com.rikkei.course141.ss1.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final Cloudinary cloudinary;

    public EmployeeController(EmployeeRepository employeeRepository, Cloudinary cloudinary) {
        this.employeeRepository = employeeRepository;
        this.cloudinary = cloudinary;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> update(@PathVariable Long id, @Valid @ModelAttribute EmployeeUpdateDTO dto) throws Exception {
        Employee emp = employeeRepository.findById(id).orElseThrow();
        emp.setFullName(dto.getFullName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        if (dto.getAvatarFile() != null && !dto.getAvatarFile().isEmpty()) {
            Map result = cloudinary.uploader().upload(dto.getAvatarFile().getBytes(),
                ObjectUtils.asMap("public_id", UUID.randomUUID().toString()));
            emp.setAvatarUrl((String) result.get("secure_url"));
        }
        return ResponseEntity.ok(ApiResponse.success(employeeRepository.save(emp)));
    }
}
