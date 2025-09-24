package com.chilllearn.fap.entity;

//class này dùng để lưu thông tin các môn học
public class Subject {
    private String code; //mã môn: swp391, hsf302
    private String name;//tên môn học
    private int credits; //số tín chỉ
    private double hours;// số giờ học

    //Khi chới với database, table thì:
    // + class này sẽ map thành cấu trúc table
    // + new Subject("SWP391", "Software Project", 3, 45);
    // => tương ứng với từng dòng trong table ~ insert into
    //Class Subject ------------ Table Subject(đến từ ERD)
    //new Subject(...) ----------- Insert into Subkect Values...

    //Bắt buộc Class phải có những thứ sau khi chơi với cơ sở dữ liệu:
    // - Constructor rỗng (Empty Constructor - CTOR)
    // - Constructor full tham số(đổ toàn bộ infor vào trong Obkect)
    // - Getter() / Setter()
    // - toString()

    //Phải chuột, GENERATE,... -> chọn mục tương ứng
    //Toàn bộ đoạn code này rất quan trọng vì giúp ta tạo ra Object 1 cách linh hoạt (tạo-new, chỉnh sửa-set, hỏi infor-get,show infor-toString)
    //Nhưng nhàm chán, ko thèm tư duy thêm
    //=> ĐOạn code nhàm chán, nhưng vẫn phải làm, ko thể thiếu -> gọi là BOILER PLATE!!!!
    public Subject() {
    }

    public Subject(String code, String name, int credits, double hours) {
        this.name = name;
        this.credits = credits;
        this.hours = hours;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public double getHours() {
        return hours;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", hours=" + hours +
                '}';
    }
}
