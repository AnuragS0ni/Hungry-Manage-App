package com.hungermanage.employee;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int empId;
  @jakarta.validation.constraints.NotNull(message = "must not be null")
  private String name;
  private double salary;
  private double advance;
  private String month;
  private String occupation;
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public double getAdvance() {
	return advance;
}
public void setAdvance(double advance) {
	this.advance = advance;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}


@Override
public String toString() {
	return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", advance=" + advance + ", month="
			+ month + ", occupation=" + occupation + "]";
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
