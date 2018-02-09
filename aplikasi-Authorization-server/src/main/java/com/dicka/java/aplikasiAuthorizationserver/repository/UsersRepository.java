package com.dicka.java.aplikasiAuthorizationserver.repository;

import com.dicka.java.aplikasiAuthorizationserver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, String>{

    @Query
    Users findByEmail(String email);
}
