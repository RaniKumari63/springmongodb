package com.solution.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequest {
	@NotBlank(message="TaskName Cannot Be null")
	private String taskName;
	@NotBlank(message="EmployeeId Cannot Be null")
	private String employeeId;
	@NotBlank(message="ProjectName Cannot Be null")
	private String projectName;
	
	private Date estimatedCompletionDate;
	private Date actualCompletionDate;
	


}
