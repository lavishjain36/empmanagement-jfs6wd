package com.guvi.empmanage.controller;

import com.guvi.empmanage.model.Employee;
import com.guvi.empmanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    //injection employeeservice into controller
//field injection
    @Autowired
    private EmployeeService employeeService;

    //handler for home page

    @GetMapping("/")
    public  String viewHomePage(Model model){
        //call findPaginated and display the list of employee in pagination
        return findPaginated(1,"firstName","asc",model);
    }

    //handler to add a New employee
    @GetMapping("/showNewEmployeeForm")
    public  String showNewEmployeeForm(Model model){
        //create an employee object
        Employee  employee=new Employee();
        model.addAttribute("employee",employee);

        //resolve thymleaf template
        return  "new_employee";
    }

    //save the data of employee->post method-
    @PostMapping("/saveEmployee")
    public  String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);

        //redirect to home page
        return  "redirect:/";

    }

    //2 controller->GetMapping and putMapping->Updateing form data


    //delete
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") Long id ){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }



    @GetMapping("/page/{pageNO}")
    private String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortDir") String sortDir,Model model)
    {
        int pageSize=5;
        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();
        //add paginated related data
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("listEmployees",listEmployees);


        return "index";
    }
}
