package com.eaststar.springbootweb.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone_number;
    }

    public void setPhone(String phone) {
        this.phone_number = phone;
    }

    @Column(name = "age")
    private String age;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "flight_id")
    private String flight_id;

    public void setSeat_number(Integer seat_number) {
        this.seat_number = seat_number;
    }

    @Column(name = "seat_number")
    private Integer seat_number;

    public Integer getSeat_number() {
        return seat_number;
    }


    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    @Column(name = "email")
    private String email;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

