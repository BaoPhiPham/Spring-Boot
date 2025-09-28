package com.chilllearn.supperapp.entity.unimany;

import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "MajorId")
    private Major major;//làm sao biến này đc set value để nói rằng SV nào này thuộc chuyên ngành nào
    //=> câu hỏi i chang, cùng logic giuống như bên major
    //=> làm hàm setMajor() để đưa 1 chuyên ngành chi sv đăng ký vào

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }
    //có thể đưa Major vào CONSTRUCTOR cx đc nhưng lưu  là nếu sau này có hơn 20 field thì khai báo 20 field trong CTOR thì ko nên - đưa qua 1 nhìu thông tin ban đầu, có thể dùng set để giải quyết
    //Có khi sau này ko dùng CTOR có tham số mà chỉ dùng CTOR rojng64 tạo OBJ trc rồi set từ từ các field, có thông tin thì set

    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return this.major;
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

