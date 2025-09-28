package com.chilllearn.supperapp.entity.unione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;
    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "Yob", nullable = false)
    private int yob;
    @Column(name = "Gpa")
    private double gpa;

    //private String majorId; //khóa ngoại  đó thầy!!! ăn đòn => Nghĩ sai: nghĩ theo style Table/CSDL => ko đúng tư duy OOP

    //Nghĩ đúng, tư duy OOP, các OBJECT có mối quan hệ
    //Tui Student tham chiếu đến thông tin Major - OBJECT
    //Có cách để CONVERT từ OOP thành TABLE/FK, JOIN COLUMN -> ORM MAPPING
    //Cần 1 tk giúp ánh xạ 2 thế giới để cho nó tương thích: JPA HIBERNATE
    //private Major majorId;

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", yob=" + yob +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
