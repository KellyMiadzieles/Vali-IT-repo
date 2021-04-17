package ee.bcs.valiit.controller;

import ee.bcs.valiit.DTO.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class EmployeeController {

    static List<Employee> employeeList = new ArrayList<Employee>();

    //http://localhost:8080/employee
    /*@GetMapping("employee")
    public List<Employee> dtoTest3() {
        Employee employee = new Employee();
        employee.setName("Kelly");
        employee.setAge(27);
        employee.setAddress("Tallinn");
        Employee employee1 = new Employee();
        employee1.setName("Malle");
        employee1.setAge(30);
        employee.setAddress("Tartu");
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(employee1);
        return employeeList;
    }

     */
    // GET Employee
    //  http://localhost:8080/employee
    @GetMapping("employee")
    public List<Employee> dtoGet() {
        return employeeList;
    }  //dtoGet on funktsiooni nimi

    // GET Employee ID
    // http://localhost:8080/employee/ID
    @GetMapping("employee/{ID}")
    public Employee dtoSearch(@PathVariable("ID") int ID) {
        return employeeList.get(ID);
    }

    // PUT Employee ID
    //  http://localhost:8080/employee/ID
    @PostMapping("employee")
    public void dtoAddEmployee(@RequestBody Employee employee) { // meeetod, siis meetodi nimi ,

        employeeList.add(employee);
    }

    //Post
    // http://localhost:8080/employee/{ID}
    @PutMapping("employee/{ID}") //PutMapping vajab RequestBody
    public void dtoReplaceEmployee(@PathVariable("ID") int index, @RequestBody Employee employee) {
        employeeList.set(index, employee); //set üle kirjutamise jaoks // millele üle kirjutab
    }

    //DELETE Employee ID
    // http://localhost:8080/employee/{ID}
    @DeleteMapping("employee/{ID}")
    public void dtoDeleteEmployee(@PathVariable("ID") int a) {

        employeeList.remove(a);
    }

}
