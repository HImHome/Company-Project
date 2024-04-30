package com.rentzosc.company.project.dtos;


import java.time.LocalDate;

public class EmployeeDTO {
    private Long employeeId;
    private Long salary;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;
    private String vacationDays;
    private String employeeAge;
    private CompanyDTO company;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long salary, String firstName, String lastName, String email, LocalDate hireDate, String vacationDays, String employeeAge, CompanyDTO company) {
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
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

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeId=" + employeeId + ", salary=" + salary + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", hireDate=" + hireDate + ", vacationDays='" + vacationDays + '\'' + ", employeeAge='" + employeeAge + '\'' + ", company=" + company + '}';
    }
}
