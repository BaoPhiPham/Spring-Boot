package com.chilllearn.fap;

import com.chilllearn.fap.entity.*;//khỏi khai báo lẻ
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //Tạo mới môn học
        Subject swt = new Subject("SWT301", "SOFTWARE TESTING", 3, 45);
        Subject hsf = new Subject("HSF302", "HIBERNAGE & SPRING FRAMEWORK", 3, 45);
        //Show infor 2 môn:
        System.out.println("SWT INFOR: " + swt);
        System.out.println("HSF INFOR: " + hsf);

        //Tạo mới Hồ sơ sinh viên:
        Student an = new Student("SE1", "Phạm An", 2004, 8.4);
        Student binh = new Student("SE2", "Bình Lê", 2004, 8.4);
        //Show info 2 bạn student:
        System.out.println("An: " + an);
        System.out.println("Bình: " + binh);

        //Chơi với JSON, từ OBJECT thành JSON và ngược lại:
        //Cần tạo Object  quản lý JSON từ thư viện:
        ObjectMapper mapper = new ObjectMapper();//mapper là ánh xạ
        //BE gửi FE, Tao server móc từ DB lên cho mày chuỗi JSON nè:
        String anJson = mapper.writeValueAsString(an);//phải có bắt ngoại lệ vì lcú convert có thể convert 1 giá trị lỗi
        System.out.println("Lần đầu tiên chuyện ấy, JSON từ OBJECT mà ra: " + anJson);
        // Từ JSON thành OBJECT, FE gửi lên BE, tao có form nhập, tao gửi mày BE JSON, mày lo thành OBJECT đi, để xuống DB:
        //String cuongJson ="{\"id\":\"SE2\",\"name\":\"Cường\",\"yob\":2004,\"gpa\":8.8}"
        String cuongJson = """
                {"id":"SE3","name":"Cường","yob":2004,"gpa":8.8}""";
        //-> đây là RAWSTRING có sao lưu vậy, có kí tự DB, giữ nguyên
        Student cuong = mapper.readValue(cuongJson, Student.class);//đưa chuỗi và convert thành OBJECT nào thuộc Class nào
        System.out.println("Cường từ JSON mà ra: " + cuong);
    }

    //CHuỗi JSON - JAVASCRIPT OBJECT NOTATION: là kĩ thuật biểu diễn thông tin của 1 OBJECT theo cú pháp ngôn ngữ JAVASCRIPT
    //C#, JAVA: OBJECT có dạng như sau:
    //  new Subject("SWT301", "SOFTWARE TESTING", 3, 45);
    //  new Student("SE2", "Bình Lê", 2004, 8.4);
    //=> nhưng code trên lá 1 môn học cụ thể, 1 bạn sv cụ thể, nhưng nhìn TEXT ko dễ hiểu, ko tự mô tả - SELF EXPLANATION
    //=> khó hiểu con số 3, 45, 8.6 nghĩa là gì, đoán thôi
    //JAVASCRIPT thì MORE SELF EXPLANATION, NHÌN EM, HIỂU EM LIỀN:
    //{"code": "SWT301", "name": "SOFTWARE TESTING", "credits": 3, "hours": 45}
    //{"id": "SE1", "name": "Phạm An", "yob": 2004, "gpa": 8.4}

    //-> Trở thành chuẩn truyền thông tin, nhiêu đây đã tự hiểu, ko cần giải thích thêm. đẵ biệt đc yêu thích trong WEB API
    //Trong mô hình WEB APP 2 cục FE và BE
    //FRONT END -----JSON----- BACK END

    //Trong code thì toàn OBJECT
    //Ra ngoài trên mạng, HTTP thì là JSON
    //=> cần 1 thư viện để giúp CONVERT qua lại JSON ---- OBJECT
    //->JACKSON, GSON xuất hiện
}