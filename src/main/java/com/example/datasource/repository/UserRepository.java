package com.example.datasource.repository;

import com.example.datasource.annotation.DataSource;
import com.example.datasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,String>, JpaSpecificationExecutor<UserEntity>
{
}
