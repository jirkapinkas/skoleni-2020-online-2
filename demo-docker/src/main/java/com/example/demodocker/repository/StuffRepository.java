package com.example.demodocker.repository;

import com.example.demodocker.entity.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Long> {
}
