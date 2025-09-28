package com.chilllearn.supperapp.entity.bidirectional;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;
    @Column(name = "Name", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    //1 chuyên ngành có nhìu sinh viên, tức là Major phải chứa 1 ArrayList Student:
    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY, mappedBy = "major")
    //Vì đã nhường JoinColumnn cho Student rồi nên Major ko bik cách nào để móc sang bên Student => thêm mappedBy = biến major - là biến để Student móc về Major bên này
    //mappedBy giúp kết noii61 ngược với bạn SV để biết cái major mà bạn ấy đang giữ có cái MajorId có khóp với Id đang đúng này hay ko
    //Major nối với Student qua đặc điêểm Major major bên Student
    //=> OBJECT quan hệ với nhau, đúng chuẩn OOP: chỉ obj mà thôi
    private List<Student> studentList = new ArrayList<>();//dùng @OneToMany thì tk Student phải có @Entity

    //studentList.add(student): đưa 1 sv vào Major
    //studentList.remove(student): 1 sv đổi chuyên ngành
    //=> Viet61 code ở đâu với 2 lệnh này??? Nguyên lí S trong S.O.L.I.D
    //                                                 SRP
    //SINGLE RESPONSIBILITY PRINCIPLE
    //Thêm xóa SV khỏi chuyên ngành, là việc của Major, thì phải Major
    //Vì chuyên ngành có nhìu SV, việc SV vào ra là viêc của Major
    //2 Hàm xóa SV và nhập SV phải thuộc Class này
    public void addStudent(Student obj) {
        this.studentList.add(obj);//1 sv đã tham gia vào chuyên ngành này
        //câu này có nghĩa là Major SE có SV này
        //nhưng chưa nói đc SV obj đang có thực sự trỏ về, lưu info chuyên ngành hay ko, info major của SV ch đc set giá trị
        //Ta cần 2 câu:
        //      + Major có SV gia nhập -> done qua lệnh studentList.addStudent(obj)
        //      + student thuộc về major này (this) --> done:
        obj.setMajor(this);//this chính là major đc new và nó gọi hàm addStudent()
        //SV obj trỏ thẳng vào major đang đứng nè nè this có đủ info id, name của Major

        //This trong OOP: class đang viết this nhưng thực chất là viết cho class là viết cho 1 vùng new đã đc đổ thông tin
        //se.addStudent(obj) thì this đang trỏ đến se
    }
    //
    public void removeStudent(Student obj){
        this.studentList.remove(obj);//1 sv đã đổi ngành sang
        obj.setMajor(null);//Tạm thời sinh viên ko còn vào ngành trc đó, giờ là null
        //chưa trỏ ngành nào
        //Ngành nào chưa biết, nhưng ko còn trong list này
    }
    //Có câu QUERY trong DB: chuyên ngành SE có bao nhiêu sinh viên
    //SELECT * FROM Major WHERE Id = 'SE'
    //OOP: Major này đang có LIST STUDENT, mình RETURN là xong !!!!!
    public List<Student> getStudentList() {
        return studentList;
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
        return String.format("|%2s|%-40s|", id, name);
    }
}
