package edu.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.entities.Student;

public interface StudentDAO extends JpaRepository<Student, String>{

}
