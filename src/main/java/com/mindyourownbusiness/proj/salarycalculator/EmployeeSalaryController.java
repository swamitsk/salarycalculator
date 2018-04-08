package com.mindyourownbusiness.proj.salarycalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class EmployeeSalaryController {

    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    @GetMapping("/employee/{id}")
    public EmployeeSalary getSalaryDetails(@PathVariable Long id) {
        return employeeSalaryRepository.getOne(id);
    }

    @GetMapping("/all")
    public List<EmployeeSalary> getSalaryDetails() {
        return employeeSalaryRepository.findAll();
    }

    @PostMapping("/employee")
    public Boolean createSalaryDetails(@RequestBody EmployeeSalary employeeSalary) {
        employeeSalary.setPaymentDate(new Date());

        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);


        if (employeeSalaryRepository.findByFirstNameAndLastNameAndMonth(employeeSalary.getFirstName(), employeeSalary.getLastName(),month+1, year).size() == 1) {
            return false;
        } else {
            employeeSalaryRepository.save(employeeSalary);
            return true;
        }
    }


}
