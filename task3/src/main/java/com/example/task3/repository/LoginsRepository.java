package com.example.task3.repository;

import com.example.task3.entity.Logins;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginsRepository extends CrudRepository<Logins, UUID> {

}
