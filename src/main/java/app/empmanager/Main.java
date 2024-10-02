package app.empmanager;

import app.empmanager.dao.impl.EmployeeDAO;
import app.empmanager.entities.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> emps = dao.getEmployees();
        for(Employee emp : emps) {
            System.out.println(emp.getId());
        }
    }
}
