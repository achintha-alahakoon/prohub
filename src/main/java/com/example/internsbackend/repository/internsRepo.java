package com.example.internsbackend.repository;

import com.example.internsbackend.model.interns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface internsRepo extends JpaRepository<interns, Integer> {

    @Query("SELECT i FROM interns i WHERE i.status = 'true'")
    List<interns> findActiveInterns();
}
