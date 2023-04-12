package com.project.ejercicio.data.repository;

import com.project.ejercicio.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends JpaRepository<UserEntity, String> {

}

