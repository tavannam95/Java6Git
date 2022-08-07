package edu.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.entities.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}
