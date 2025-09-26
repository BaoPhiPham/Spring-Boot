package com.chilllearn.supperapp.entity;

import jakarta.persistence.*;

@Entity//em muốn map/ánh xạ Class này thành 1 table tương ứngsố cột, số field
@Table(name = "Lecturers")//Tên table có thể khác tên Class, thì dùng @table, ko dùng cx đc

public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tự generate Key, là con số tự tăng từ 1; IDENTITY dùng vs sqlserver, nếu là AUTO thì dùng MySQL
    @Column(name = "Id" )
    private Long id;
    @Column(name = "Name", nullable = true, columnDefinition = "NVARCHAR(50)", length = 50)
    private String name;//Nvarchar(50) not null
    @Column(name = "Yob", nullable = true)
    private int yob;
    @Column(name = "Salary")
    private double salary;

    //Có thể dùng Lombok để loại bỏ Boiler-Plate
    //Nhưng bắt buộc phải có:
    //CTOR rỗng, full tham số, get set, to string
    //ko dùng lombok:
    public Lecturer() {

    }

    //FULL tham số, bớt đi cột tự tăng, vẫn là full
    //Key tự tăng thì ch chắc đã dùng lombox đc
    public Lecturer(String name, int yob, double salary) {
        this.name = name;
        this.yob = yob;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", salary=" + salary +
                '}';
    }

}
