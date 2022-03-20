package com.dsg.springbootboardexample.repository;

import com.dsg.springbootboardexample.entity.Role;
import com.dsg.springbootboardexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
