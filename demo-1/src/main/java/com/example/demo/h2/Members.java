package com.example.demo.h2;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(value = "members")
public class Members implements Serializable {

	private static final long serialVersionUID = 8124227299932339862L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(value="m_num")
	private long mNum;
	
	@Column(value="name")
	private String name;
	
	@Column(value="age")
	private int age;
}
