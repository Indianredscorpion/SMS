package com.sms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="dept")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	private int deptId;
	
	@Column(length = 20, nullable=false)
	private String deptName;
	
	@Column
	private int totalSmp;
	
	@OneToMany //in one department there can be many studants
	private List<Studant> studants;
}
