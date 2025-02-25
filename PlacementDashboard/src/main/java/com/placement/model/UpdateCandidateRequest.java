package com.placement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCandidateRequest {
	private String candidateId;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String phone;
	private Address address;
	private String role;
	private String visatype;
}
