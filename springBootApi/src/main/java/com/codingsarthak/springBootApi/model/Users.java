package com.codingsarthak.springBootApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Roll_No")
    private long Roll_No;
    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String LastName;

    @Column(name = "Email")
    private String email;

    public long getRoll_No() {
        return Roll_No;
    }

    public void setRoll_No(long roll_No) {
        Roll_No = roll_No;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(long roll_No, String firstName, String lastName, String email) {
        Roll_No = roll_No;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
    }

    public Users(String firstName, String lastName, String email) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
    }

    public Users() {

    }


}
