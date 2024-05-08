package com.guvi.empmanage.service;

import com.guvi.empmanage.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    //define services
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Page<Employee> findPaginated(int pageNo,int pageSize,String sortField,String sortDirection);

}
