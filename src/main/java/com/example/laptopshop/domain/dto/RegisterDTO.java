package com.example.laptopshop.domain.dto;

import com.example.laptopshop.service.validator.RegisterChecked;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterChecked
public class RegisterDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}
