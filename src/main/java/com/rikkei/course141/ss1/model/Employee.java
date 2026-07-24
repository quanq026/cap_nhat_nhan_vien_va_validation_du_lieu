package com.rikkei.course141.ss1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "employees") @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String fullName;
    private String email;
    private String department;
    private String avatarUrl;
}
