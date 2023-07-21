package com.sms.model;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Studant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudantDTO {

    @NotNull(message="Department Id cannot be null")
    private int deptId;

    @NotNull(message="Department Name cannot be null")
    @NotBlank(message="Deparment Name is mandatory")
    @Size(min=2, message="Min 2 characters is required")
    @Size(max=20, message = "Max 20 characters allowed")
    private String deptName;

    @NotNull(message="Total No. of Studants cannot be null")
    private int totalStudant;

    @OneToMany
    private List<Studant> students;
}
