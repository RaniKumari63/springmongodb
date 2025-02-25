package com.solution.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

@NotBlank(message="FirstName Cannot Be null")
private String firstName;

@NotBlank(message="LastName Cannot Be null")
private String lastName;
@NotBlank(message="Email Cannot Be Null")
@Email(message="Email Must Be Correct Format")
private String email;
@NotBlank(message="PhoneNo Cannot Be Null")
private String phone;
private Address address;
@NotBlank(message="Password Cannot Be Null")
private String password;
@NotBlank(message="Role Cannot Be Null")
private String role;

}
