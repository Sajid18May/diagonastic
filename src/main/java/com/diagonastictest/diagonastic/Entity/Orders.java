package com.diagonastictest.diagonastic.Entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int order_id;
//private int patient_id ;
//private int test_id ;
private Date order_date;
private String status ;
private String results;


}
