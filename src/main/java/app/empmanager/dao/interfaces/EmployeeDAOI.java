package app.empmanager.dao.interfaces;

import app.empmanager.entities.Employee;

import java.util.List;

public interface EmployeeDAOI {
    void addEmployee(Employee employee);
    List<Employee> getEmployees();
    void deleteEmployee(Employee employee);
    Employee getEmployeeById(int id);
    void updateEmployee(Employee employee);
}
