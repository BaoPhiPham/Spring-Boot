package com.chilllearn.supperapp.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.*;
//import org.hibernate.annotations.Nationalized;// chú ý 1 điều là import dòng này thì khi dùng Nationalized sẽ chỉ dùng nếu có hibernate => nếu chơi vs các nah2 thầu khác như Ecliplink thì Nationalized sẽ ko dùng đc => ko thể sử dụng trong project có nhiều nhà cung cấp JPA => ko hiệu quả

//Class sẽ đc khai báo để ánh xạ/biến đổi tương đương, Map thành table tương ứng
@Entity
@Table(name = "Student")//nếu ko có khai báo này thì mặc định lấy tên Class thành tên Table!!!

public class Student {

    @Id //khai báo primary key cho Class này để ánh xạ qua Table
    @Column(name = "Id", columnDefinition = "CHAR(8)")//nếu ko có khai báo này thì mặc định lấy tên biến/field làm tên cột; columnDefinition là cách độ 1 kiểu cột theo chuẩn SQLServer hoặc theo chuẩn các cơ sở dữ liệu khác mà bạn đag dùng
    private String id;//camelCase,table thì id có thể viết hoa hay viết thường tuy ng code dùng quy tắc nào, đang dùng id tự nhập(id tự tăng tính sau); ko nói năng gì cả thì String vô DB sẽ là varchar, điều này làm truy vấn tốn perfomence hơn

    @Column(name = "Name", nullable = false, length = 50, columnDefinition = "NVARCHAR(50)")
    //@Nationalized //thiếu khai báo này, thì String -> Varchar nên ko lưu đc t việt có dấu. Để String -> Nvarchar thì cần thêm khai báo @Nationalized, nếu ko tiếng việt sẽ ra dấu hỏi chấm thay thế dấu '\?~/
    //Ta dùng @Nationalized của Hibernate sẽ mất tính khả chuyển (extension), thì code này sẽ ko chs đc vs nhà thầu Eclipselink
    // => Nên ta sẽ độ Nvarchar chs với nhìu nhà cung cấp ORM/JPA
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    //Bắt buộc phải có Constructor rỗng và full tham số
    //=> quy ước phải có trong việc mapping
    //Thêm Get, Set và toString
    //Thêm dependence Lombox sau...


    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }

}
