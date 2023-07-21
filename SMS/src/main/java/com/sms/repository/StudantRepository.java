package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sms.entity.Studant;

public interface StudantRepository extends JpaRepository<Studant, Integer> {

    //custom method to get studant details using the studant name
    @Query("from Studant where studantName=:name")
	static
    List<Studant> getStudantByName(@Param("name") String name) {
		// TODO Auto-generated method stub
		return null;
	}

    //custom method to get studant details using the studant email with finder method
    static Studant findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	void save(List<Studant> studant);
}
