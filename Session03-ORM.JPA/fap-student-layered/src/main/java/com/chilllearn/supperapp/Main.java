package com.chilllearn.supperapp;

import com.chilllearn.supperapp.entity.Student;
import com.chilllearn.supperapp.service.StudentService;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //FLOW: UI --- SERVICE --- REPO --- JpaUtil (Entity Manager Factory) --- TABLE
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        //1. Tạo mới hồ sơ sinh viên
        Student an = new Student("SE10", "An Nguyễn", 2005, 8.6);
//        studentService.createStudent(an);
//        studentService.createStudent(new Student("SE11", "Bình Lê", 2005, 8.7));
        //2. SHOW ALL
        System.out.println("THE LIST STUDENTS: ");
        studentService.getAllStudents().forEach(x -> System.out.println(x));
        //3. Update 1 hồ sơ SV: nhớ là comment insert ở trên
//        an = new Student("SE10", "An Nguyễn Văn", 2005, 9.2);
//        studentService.updateStudent(an);
//        System.out.println("THE LIST STUDENTS AFTER UPDATING: ");
//        studentService.getAllStudents().forEach(x -> System.out.println(x));
        //4. REMOVE 1 hồ sơ SV
        studentService.deleteStudentById("SE11");
        System.out.println("THE LIST STUDENTS AFTER DELETING: ");
        studentService.getAllStudents().forEach(x -> System.out.println(x));
    }
}