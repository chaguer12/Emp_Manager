package app.empmanager.dao.impl;

import app.empmanager.dao.interfaces.EmployeeDAOI;
import app.empmanager.entities.Employee;
import app.empmanager.entities.sessionFactory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAO implements EmployeeDAOI {
    @Override
    public void addEmployee(Employee employee) {
        Transaction trns = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trns = session.beginTransaction();
            session.save(employee);
            trns.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public List<Employee> getEmployees() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Employee",Employee.class).list();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void deleteEmployee(Employee employee) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee emp = session.get(Employee.class, employee.getId());
            session.delete(emp);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Employee getEmployeeById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }
    }

}
