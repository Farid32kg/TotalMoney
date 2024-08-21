package com.example.back_end.repository;

import com.example.back_end.model.Totalmoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalRepository extends JpaRepository<Totalmoney,Long> {
}
