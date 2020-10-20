package com.example.neotechhub;

import java.io.Serializable;

public class EnquiryModel implements Serializable {

    String name;
    String surname;
    String email;
    String dob;
    String address;
    String gender;
    String contact;
    String stream;
    String college;
    String gettoknow;
    String course;
    String image;


    public EnquiryModel() {
    }

    public EnquiryModel(String name, String surname, String email, String dob, String address, String gender, String contact, String stream, String college, String gettoknow, String course, String image) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.contact = contact;
        this.stream = stream;
        this.college = college;
        this.gettoknow = gettoknow;
        this.course = course;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGettoknow() {
        return gettoknow;
    }

    public void setGettoknow(String gettoknow) {
        this.gettoknow = gettoknow;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
