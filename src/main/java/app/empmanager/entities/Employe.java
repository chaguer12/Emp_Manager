package app.empmanager.entities;

import java.sql.Date;

public class Employe {
    private int id;
    private String name;
    private String lastname;
    private double salary;
    private Date insertionDate;
    public Employe(int id, String name, String lastname, double salary, Date insertionDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.salary = salary;
        this.insertionDate = insertionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }
}
