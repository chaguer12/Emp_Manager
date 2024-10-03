package app.empmanager.dao.impl;

import app.empmanager.dao.interfaces.EmployeeDAOI;
import app.empmanager.entities.Employee;
import app.empmanager.entities.sessionFactory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
            Transaction trns = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            trns = session.beginTransaction();
            session.delete(employee);
            trns.commit();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void updateEmployee(Employee employee) {
        Transaction trns = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            trns = session.beginTransaction();
            session.update(employee);
            trns.commit();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<Employee> getEmpByName(String input){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            String sql = "from employees where name like '%:input' or lastname like '%:input'";
            Query query = (Query) session.createQuery(sql);
            query.setParameter("input",input);
            List<Employee> emps = query.getResultList();
            session.getTransaction().commit();
            return emps;



        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
