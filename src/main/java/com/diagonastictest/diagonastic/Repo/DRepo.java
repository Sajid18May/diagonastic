package com.diagonastictest.diagonastic.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;

public interface DRepo extends JpaRepository<DiagnosticTests,Integer>{
    
}
