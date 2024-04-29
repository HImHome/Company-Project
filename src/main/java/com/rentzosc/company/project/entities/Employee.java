package com.rentzosc.company.project.entities;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    @Column(name = "vacation_days")
    private String vacationDays;
    @Column(name = "age")
    private String employeeAge;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, Long salary, LocalDate hireDate, String vacationDays, String employeeAge, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
        this.vacationDays = vacationDays;
        this.employeeAge = employeeAge;
        this.company = company;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(String vacationDays) {
        this.vacationDays = vacationDays;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", salary=" + salary + ", hireDate=" + hireDate + ", vacationDays='" + vacationDays + '\'' + ", employeeAge='" + employeeAge + '\'' + ", company=" + company + '}';
    }
}