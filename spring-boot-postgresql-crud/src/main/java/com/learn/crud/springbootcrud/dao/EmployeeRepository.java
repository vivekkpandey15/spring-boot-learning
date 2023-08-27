package com.learn.crud.springbootcrud.dao;

import com.learn.crud.springbootcrud.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
}
