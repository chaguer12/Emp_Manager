package app.empmanager.servlets;

import app.empmanager.entities.Employee;
import app.empmanager.services.EmployeeService;
import app.empmanager.services.interfaces.EmployeeServInterface;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeServInterface empService;
    @Override
    public void init() throws ServletException {

        empService = new EmployeeService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        switch(action){
            case "PATCH":
                dataTransporter(req,resp);
                break;
            case "LIST":
                listEmplos(req,resp);
                break;
            default:
                listEmplos(req,resp);
                break;

        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        if("DELETE".equals(method)) {
            doDelete(req, resp);
        }else {
            String name = req.getParameter("nom");
            String lastName = req.getParameter("prenom");
            String email = req.getParameter("email");
            String tel = req.getParameter("tel");
            String poste = req.getParameter("poste");
            String departement = req.getParameter("departement");
            Employee employee = new Employee(name, lastName, tel, email, poste, departement);
            empService.addEmployee(employee);
            resp.sendRedirect("/");
        }

    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee emp = empService.getEmployeeById(id);
        empService.deleteEmployee(emp);
        resp.sendRedirect("/emplist");
    }
    private void listEmplos(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        List<Employee> employees = empService.getEmployees();
        req.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/view/Employees.jsp").forward(req, resp);
    }
    private void dataTransporter(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        Employee emp = empService.getEmployeeById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("employee",emp);
        req.getRequestDispatcher("/view/UpdateForm.jsp").forward(req, resp);
    }




}
