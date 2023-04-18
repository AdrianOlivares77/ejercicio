package com.project.ejercicio.domain.repository;

import com.project.ejercicio.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends JpaRepository<UserEntity, String> {

}

