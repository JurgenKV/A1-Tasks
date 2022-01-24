package com.example.task3.repository;

import com.example.task3.entity.Supplies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SuppliesRepository extends CrudRepository<Supplies, UUID> {
    public List<Supplies> getAllByPstngDateContains(String date);
}