package com.rentzosc.company.project.repositories;

import com.rentzosc.company.project.entities.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {
}
