package edu.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.entities.Account;

public interface AccountDAO extends JpaRepository<Account, String>{

}
