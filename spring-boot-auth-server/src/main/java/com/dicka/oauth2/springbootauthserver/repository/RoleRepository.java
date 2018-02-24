package com.dicka.oauth2.springbootauthserver.repository;

import com.dicka.oauth2.springbootauthserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
