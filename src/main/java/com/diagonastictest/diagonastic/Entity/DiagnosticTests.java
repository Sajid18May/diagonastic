package com.diagonastictest.diagonastic.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class DiagnosticTests {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int test_id;
private String test_name;
private String lab_name;
private String processing_time;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "test_id", referencedColumnName="test_id")
List <Orders> orders;
}
