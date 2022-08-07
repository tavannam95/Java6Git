package edu.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.entities.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{

}
