package com.rentzosc.company.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequestRepository, Long> {
}