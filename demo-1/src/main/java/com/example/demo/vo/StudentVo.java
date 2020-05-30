package com.example.demo.vo;

public class StudentVo {
	int id;
	String name;
	String passport_number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}
	@Override
	public String toString() {
		return "StudentVo [id=" + id + ", name=" + name + ", passport_number=" + passport_number + ", toString()="
				+ super.toString() + "]";
	}
	
}
