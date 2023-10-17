package com.diagonastictest.diagonastic.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diagonastictest.diagonastic.Entity.Patients;

@Repository
public interface Repo extends JpaRepository<Patients,Integer>{

}
