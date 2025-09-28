package com.chilllearn.supperapp.entity.bidirectional;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
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

    //Sinh vinê thuộc về 1 chuyên ngành Major tại 1 thời điểm, 1 binế Major thoy, ko phải là List như bên Class Major:
    @ManyToOne
    @JoinColumn(name = "MajorId")//cả Major và Student đều có quyền khai báo JoinColumn, nếu dùng uni-directional relationship
    // giờ làm bi-directional, 2 tk nhìn qua lại với nhau, thì ta có quyền giữ JoinColumn về tk N cho nó giống như góc nhìn TABLE
    private Major major;
    //phải set chuyên ngành này cho bạn sv này qua hàm set()
    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return this.major;
    }

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
//        return "Student{" +
//                "gpa=" + gpa +
//                ", yob=" + yob +
//                ", id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                '}';
        //Căn lề như danh sách thí sinh thi:
        return String.format("|%2s|%-40s|%4d|%4.1f|", id, name, yob, gpa);
    }

}