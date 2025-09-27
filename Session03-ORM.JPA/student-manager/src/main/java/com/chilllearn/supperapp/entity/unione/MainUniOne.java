package com.chilllearn.supperapp.entity.unione;

import com.chilllearn.supperapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniOne {
    //psvm để có hàm main
    //nhờ vả JpaUtil có hàm đọc file persistence.xml để kết noiu61 đúng CSDL, đúng Driver và giíup tạo ra ô quản lí EntityManager
    public static void main(String[] args) {
        createMajorStudents();
    }

    public static void createMajorStudents(){
        //ta tạo chuyên ngành SE và 2 sv của chuyên ngành này:
        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING | KĨ THUẬT PHẦN MỀM");
        Student s1 = new Student("SE100", "An Nguyễn", 2006, 8.6);
        Student s2 = new Student("SE101", "Bình Lê", 2006, 8.6);

        //seMajor cần phải add 2 student s1, s2 vào cái List students
        //Làm sao add???
        seMajor.addStudent(s1);
        seMajor.addStudent(s2);
        //OOP đã xong về RELATIONSHIP
        //Xuống TABLE, đổ DOMINO - CASCADE 1 MAJOR, N STUDENT xuống luôn theo
        //                          ONE đi xuống, MANY đi theo!!!!!
        //Nhờ JpaUtil chuẩn bị nah2 xưởng FACTORY, mời giám đốc về quản lý Entity
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(seMajor);//Major đi xuống, 2 Student theo sau!!!
        em.getTransaction().commit();
        em.close();
    }
}
