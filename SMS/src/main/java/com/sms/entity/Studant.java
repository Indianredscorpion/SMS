package com.sms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Studant extends User{

	@Column(length=20, nullable = false)
	private String smpName;
	
	@Column(nullable = false)
	private double mark;
	
	@Column(length=10, nullable = false, unique = true)
	private String contact;
	
	@Column(length=30, nullable = false, unique=true)
	private String email;
	
	@Column(length=20, nullable = false)
	private String subject;
	
	@Column
	private LocalDate doj;
	
	@ManyToOne //many employees can work under one department
	private Department dept;

	@Builder
	public Studant(int id, String userName, String password, Role role, String smpName, double mark, String contact,
			String email, String subject, LocalDate doj, Department dept) {
		super(id, userName, password, role);
		this.smpName = smpName;
		this.mark = mark;
		this.contact = contact;
		this.email = email;
		this.subject = subject;
		this.doj = doj;
		this.dept = dept;
	}
	
	
}
