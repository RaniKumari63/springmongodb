package com.solution.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

@NotBlank(message="EmployeeName Cannot Be null")
private String employeeName;


@NotBlank(message="Email Cannot Be Null")
@Email(message="Email Must Be Correct Format")
private String employeeEmailId;

private String managerId;

private String managerName;

private String managerEmailId;

@NotBlank(message="PhoneNo Cannot Be Null")
private String phone;
private Address address;
@NotBlank(message="Password Cannot Be Null")
private String password;



}
