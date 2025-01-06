package com.hungermanage.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

@Autowired
public EmployeeRepo employeeRepo;
 @GetMapping("/all")
 public List<Employee> getAllEmployees(){
	 return employeeRepo.findAll();
 }
 
 @PostMapping
 public Employee addEmployee(@RequestBody Employee employee){
	 return employeeRepo.save(employee);
 }
 
 @PutMapping
 public Employee UpdateEmployee(@RequestBody Employee employee){
	Optional<Employee> oldEmp =employeeRepo.findById(employee.getEmpId());
	if(oldEmp.isPresent())
	{ Employee empFromDB=oldEmp.get();
	empFromDB.setEmpId(employee.getEmpId());
	empFromDB.setAdvance(employee.getAdvance());
	empFromDB.setMonth(employee.getMonth());
	empFromDB.setOccupation(employee.getOccupation());
	employeeRepo.save(empFromDB);
	}else {
		System.out.println("Employee is not present in DB");
	}
	
	return employee; 
 }
 
 @DeleteMapping
 public String Delete(@RequestBody Employee employee) {
	 
	 if(employeeRepo.findById(employee.getEmpId()).isPresent()) {
	 employeeRepo.delete(employee); 
	 }else {
		 return "Employee not found";
	 }
	  return "Emplpoyee Deleted";
 }
 

}
