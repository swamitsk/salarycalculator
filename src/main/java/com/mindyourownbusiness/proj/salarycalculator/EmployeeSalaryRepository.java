package com.mindyourownbusiness.proj.salarycalculator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary,Long> {

    @Query("SELECT es FROM EmployeeSalary es WHERE es.firstName = :firstName and es.lastName = :lastName " +
            "and MONTH (es.paymentDate) = :month and YEAR (es.paymentDate) = :year")
    List<EmployeeSalary> findByFirstNameAndLastNameAndMonth(@Param("firstName") String firstName, @Param("lastName") String lastName,
                                                            @Param("month") Integer month, @Param("year") Integer year);
}