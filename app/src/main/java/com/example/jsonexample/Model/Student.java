package com.example.jsonexample.Model;


import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    private String sid;
    private String sname;
    private String gender;
    private String username;
    private String email;
    private String street;
    private String suite;
    private String city;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String zipcode;
    private String country;

    private ArrayList<Student> studentArrayList;

    public Student(String sid, String sname, String gender, String username, String email, String street,
                   String suite, String city, String zipcode, String country) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.username = username;
        this.email = email;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }


    public Student()
    {
        this.sid ="";
        this.sname =  "";
        this.gender = "";
        this.username = "";
        this.email = "";
        this.street = "";
        this.suite = "";
        this.city = "";
        this.zipcode = "";
        this.country = "";
        studentArrayList = new ArrayList<>();
    }
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    @Override
    public String toString() {
        return "Student Details" +"\n"+
                "\n"+
                "Name   " + sname +"\n" +
                "\n"+
                "Gender  " + gender  +"\n"+
                "\n"+
                "User Name  " + username  +"\n"+
                "\n"+
                "Email    "+ email  + "\n" +
                "\n"+
                "House Number "+ street  + "\n"+
                "\n"+
                "Street Name  " + username + "\n" +
                "\n"+
                "City Name   " + city  + "\n" +
                "\n"+
                "Country    " + country  + "\n" +
                "\n"+
                "Zip Code   " + zipcode + "\n"
                ;
    }
}
