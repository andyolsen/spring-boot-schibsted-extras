package com.example;

import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {


    @Override
    public Employee process(Employee emp) {

        Employee transformedEmp = new Employee(
                emp.firstname().toUpperCase(),
                emp.lastname().toUpperCase(),
                emp.salary()
        );

        System.out.printf("Transforming %s into %s\n", emp, transformedEmp);

        return transformedEmp;
    }
}