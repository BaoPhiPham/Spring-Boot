package com.chilllearn.supperapp.service;

import com.chilllearn.supperapp.entity.Student;
import com.chilllearn.supperapp.repository.StudentRepo;

import java.util.List;

public class StudentService {

    //Class này đứng giữa, hứng infor từ user, tạo OBJECT, đẩy xuống cho repo lo giúp
    //Nó cx nhờ REPO lấy OBJECT từ Table, đẩy ngc lên UI cho USER xem
    //chắc chắn nó phỉa khai báo binế REPO để REPO giúp
    //Chỉ cần 1 biến REPO dùng chung cho các hàm do mình gopị bên trong REPO
    //Class này phải chuẩn bị OBJECT để đưa xuống REPO
    //Tên hàm CLASS này thường đặt gần gũi cới USER hơn, do gần USER hơn DB, mình là SERVICE cung cấp DATA cho USER, và nhận thầu DATA từ USER
    //Tên hàm gợi ý: createStudent(), getAllStudents, updateStudent(), deleteStudent
    private StudentRepo studentRepo = new StudentRepo();

    public void createStudent(Student obj){
        //Cần REPO, dùng riêng hay chung đều OKE
        //TODO: check trùng KEY, EMAIL, VALIDATE,....
        //TODO: Bắt try catch thông báo...
        studentRepo.save(obj);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public void updateStudent(Student obj){
        studentRepo.update(obj);
    }

    public void deleteStudent(Student obj){
        studentRepo.delete(obj);
    }

    public void deleteStudentById(String id){
        studentRepo.delete(id);
    }

}
