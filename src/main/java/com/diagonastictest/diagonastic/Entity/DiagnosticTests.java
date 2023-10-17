package com.diagonastictest.diagonastic.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DiagnosticTests {
@Id
private int test_id;
private String test_name;
private String description;
private double price;
private String sample_type;
private String processing_time;
}
