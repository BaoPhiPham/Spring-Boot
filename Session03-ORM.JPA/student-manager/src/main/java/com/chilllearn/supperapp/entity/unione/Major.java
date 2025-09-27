package com.chilllearn.supperapp.entity.unione;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")//thiếu columnDefinition sẽ thành VARCHAR(255)
    private String id;//mã chuyên ngành
    @Column(name = "Name", columnDefinition = "NVARCHAR(100)", nullable = false)//ko dùng @Nationalized nửa, để độc lập Hibernate, dễ dàng chuyển snag chs vs ORM JPA Driver khác, ví dụ Eclipselink!!!
    private String name;//tên chuyên ngành

    //Câu trong CSDL, câu trong đời thường: 1 major có nhiều sinh viên:
    //Muốn lưu nhìu info thì dùng List hoặc ArrayList thẳng tiến, OBJECT nbày tham chiếu thông tin OBJECT kia
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // nhờ câu này thì bảng Table Student xuất hiện và nó sẽ đòi FK/JOIN COLUMN
    @JoinColumn(name = "MajorId")//tự tạo bên table Many Student 1 cột FK tên là MajorId, bên kia ko cần làm gì , mình chỉ làm bên này thôi
    private List<Student> students = new ArrayList<>();
    //Để có cụ thể SV nào, ta gọi students.add(1 bạn sv đc new đâu đó)
    //                            students.add(new Student("SE1", "An"))
    //add 1 phần tử vào trong ArrayList
    //=>unione dành cho tình huống chỉ quan tâm danh sách major, ko quan tâm đến các sv cụ thể, chỉ quản lý thông tin major

    //hàm add sv vào List, public => đúng nguyên tắc SOLID, major nắm ds sv thì để major add
    public void addStudent(Student obj) {
        //if else login kiểm soát info bên ngoài đi vào trong object
        students.add(obj);
    }


    public Major(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Major() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
