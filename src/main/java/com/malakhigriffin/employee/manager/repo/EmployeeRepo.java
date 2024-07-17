package com.malakhigriffin.employee.manager.repo;

import com.malakhigriffin.employee.manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);
        //created own method

    //JpaRepository gives a bunch of methods to use on employees in the database like save() or find()

}
