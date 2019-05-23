package com.example.springBootKafakaProducer;

public class User {
   private String name;
   private String dept;
   private int salary;
   
public User(String name, String dept, int salary) {
	super();
	this.name = name;
	this.dept = dept;
	this.salary = salary;
}
public String getName() {
	return name;
}
@Override
public String toString() {
	return "User [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
}
