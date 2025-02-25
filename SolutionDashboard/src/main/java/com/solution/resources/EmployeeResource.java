package com.solution.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solution.model.Blocker;
import com.solution.model.CreateEmployeeRequest;
import com.solution.model.CreateTaskRequest;

import com.solution.model.UpdateEmployeeRequest;
import com.solution.model.UpdateTaskRequest;
import com.solution.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/solution/employee")
public class EmployeeResource {
@Autowired
EmployeeService employeeService;
@PostMapping("/createEmployee")
public ResponseEntity<?> createEmployee(@RequestBody  @Valid CreateEmployeeRequest request) {

	return this.employeeService.createEmployee(request);
}
@GetMapping("/getemployees")
public ResponseEntity<?> getEmployees(@RequestParam(required=false)String searchInput)
{
	return this.employeeService.getEmployees(searchInput);
}
@GetMapping("/getallemployeenames")
public ResponseEntity<?> getEmployeeNames(@RequestParam String managerId)
{
	return this.employeeService.getAllEmployeeNames(managerId);
}
@GetMapping("/getemployee")
public ResponseEntity<?> getEmployee(@RequestParam String employeeId) {
	return this.employeeService.getEmployeeById(employeeId);
}


@GetMapping("/gettaskbyemployee")
public ResponseEntity<?> getEmployeeWithTask(@RequestParam String employeeId)
{
	return this.employeeService.getEmployeeByIdWithTask(employeeId);
}
@PostMapping("/addBlockers")
public ResponseEntity<?> addBlockers(@RequestParam String employeeId,@RequestParam String taskId,@RequestBody List<Blocker> blockers) 
{
	return this.employeeService.addBlockers(employeeId,taskId, blockers);
}

@GetMapping("/getemployeetrack")
public ResponseEntity<?> getEmployeeTrack(@RequestParam String managerId)
{
	return this.employeeService.getEmployeeTrack(managerId);
//return null;
}

@PutMapping("/updateemployee")
public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeRequest request) {
	return this.employeeService.updateEmployee(request);
	
}

@DeleteMapping("/deleteemployee")
public ResponseEntity<?> deleteEmployee(@RequestParam String employeeId) {
	return this.employeeService.deleteEmployee(employeeId);
}
@PostMapping("/createTask")
public ResponseEntity<?> createTask(@RequestBody  @Valid CreateTaskRequest request) {

	return this.employeeService.createTask(request);
}
@GetMapping("/gettasks")
public ResponseEntity<?> getTasks(@RequestParam(required=false)String searchInput)
{
	return this.employeeService.getTasks(searchInput);
}
@GetMapping("/gettask")
public ResponseEntity<?> getTask(@RequestParam String taskId) {
	return this.employeeService.getTaskById(taskId);
}

@PutMapping("/updatetask")
public ResponseEntity<?> updateTask(@RequestBody UpdateTaskRequest request) {
	return this.employeeService.updateTask(request);
	
}

@DeleteMapping("/deletetask")
public ResponseEntity<?> deleteTask(@RequestParam String taskId) {
	return this.employeeService.deleteTask(taskId);
}


}
