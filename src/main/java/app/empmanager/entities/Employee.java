package app.empmanager.entities;

import jakarta.persistence.*;
import org.hibernate.Session;

import java.sql.Date;

public class Employee {

    private int id;
    private String name;
    private String lastname;
    private double tel;
    private String email;
    private String poste;
    private String department;
    public Employee(String name, String lastname, double tel, String email, String poste, String department) {
        this.name = name;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
        this.poste = poste;
        this.department = department;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee() {}


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






}
