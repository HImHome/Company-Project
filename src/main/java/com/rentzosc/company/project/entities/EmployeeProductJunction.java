package com.rentzosc.company.project.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class EmployeeProductJunction {
    @Id
    @GeneratedValue
    Long employeeProductJunctionId;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    @ManyToOne
    @JoinColumn
    private Product product;
}
