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
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        empService = new EmployeeService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       List<Employee> employees = empService.getEmployees();
       req.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
