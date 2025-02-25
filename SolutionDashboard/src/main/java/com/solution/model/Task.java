package com.solution.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solution.constant.CollectionConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection=CollectionConstants.TASKS)
public class Task {
	@Id
	private String taskId;
	private String taskName;
	
	private String employeeId;
	private String projectName;
	private Date estimatedCompletionDate;
	private Date actualCompletionDate;
	
	private List<Blocker> blocker;
	@JsonIgnore
	private String status;
	
}
