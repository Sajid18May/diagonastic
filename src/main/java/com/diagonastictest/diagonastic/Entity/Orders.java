package com.diagonastictest.diagonastic.Entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
