package com.zh.ems.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
	private Integer id;
	private String nickname;
	private String password;
	private String gender;
	private double salary;
	
	public Emp(Integer id, String nickname, String password, String gender, double salary) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.gender = gender;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", nickname=" + nickname + ", password=" + password + ", gender=" + gender
				+ ", salary=" + salary + "]";
	}

	
	
}
