package com.soit.soitfaculty.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soit.soitfaculty.entity.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    public List<Faculty>findAllByOrderByLastName();
}
