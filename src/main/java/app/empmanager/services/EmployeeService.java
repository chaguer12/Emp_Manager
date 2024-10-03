package app.empmanager.services;

import app.empmanager.dao.impl.EmployeeDAO;
import app.empmanager.dao.interfaces.EmployeeDAOI;
import app.empmanager.entities.Employee;
import app.empmanager.services.interfaces.EmployeeServInterface;

import java.util.List;

public class EmployeeService implements EmployeeServInterface {
    private EmployeeDAOI dao = new EmployeeDAO();
    @Override
    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);
    }
    @Override
    public List<Employee> getEmployees() {
        List<Employee> emplos = dao.getEmployees();
        return emplos;
    }
    @Override
    public void deleteEmployee(Employee employee) {
        dao.deleteEmployee(employee);
    }
    @Override
    public Employee getEmployeeById(int id){
        return dao.getEmployeeById(id);
    }
    @Override
    public void updateEmployee(int id) {
        Employee emp = dao.getEmployeeById(id);
        dao.updateEmployee(emp);
    }
}
