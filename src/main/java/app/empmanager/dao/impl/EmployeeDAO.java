package app.empmanager.dao.impl;

import app.empmanager.dao.interfaces.EmployeeDAOI;
import app.empmanager.entities.Employee;
import app.empmanager.entities.sessionFactory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
