package app.empmanager.services.interfaces;

import app.empmanager.entities.Employee;

import java.util.List;

public interface EmployeeServInterface {
    void addEmployee(Employee employee);
    List<Employee> getEmployees();
}
