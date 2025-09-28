package com.chilllearn.supperapp.entity.bidirectional;


import com.chilllearn.supperapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainBiOneMany {

    public static void main(String[] args) {
//        createMajorStudent();
        getAll();
    }

    public static void createMajorStudent(){
        Major se = new Major("SE", "SOFTWARE ENGINEEERING | KĨ THUẬT PHẦN MỀM");
        Major gd = new Major("GD", "GRAPHIC DESIGN | MỸ THUẬT SỐ");
        Student an = new Student("SE1000", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE1001", "BÌNH LÊ", 2004, 8.7);
        Student cuong = new Student("GD1000", "CƯỜNG VÕ", 2005, 8.6);
        Student dung = new Student("GD1001", "DUNG PHẠM", 2005, 8.7);

        //kết nối chuyên ngành , STYLE OBJECT:
        se.addStudent(an);
        se.addStudent(binh);
        gd.addStudent(cuong);
        gd.addStudent(dung);

        //Mời giám đốc EntityManager về quản lí đam01 @Entity
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se);//đổ domino do nhìn từ 2 chiều
        em.persist(gd);
        em.getTransaction().commit();
        em.close();
    }

    //Lấy danh sách sinh viên, danh sách chuyên ngành
    //em có hàm lợi hại: .find(Class, key) -> trả về duy nhất 1 dòng theo key
    //                   .createQuery(câu JPQL) --> trả về 1 List, LIST 1 dòng hay nhìu dòng tùy câu WHERE
    //Vì OOP 2 chiều, nên khi lấy đc 1 Major SE, ko cần WHERE gì nửa, vào thẳng LIST của SE  là lấy FULL Student của SE, ta lấy qua Object Major mà lại có LIST Student, vì Major có nhìu SV
    //Thày vì chs trực tiếp vs TABLE Student
    public static void getAll(){
        EntityManager em = JpaUtil.getEntityManager();
        Major se = em.find(Major.class, "SE");//có chuyên ngành và có luôn cả List Student
        System.out.println("SE major info: " + se);
        //để LAZY nên phải load
        List<Student> stuList = se.getStudentList();// này là ko LAZY nưả mà sẽ load luôn
        //In bằng biểu thức LAMBDA
        System.out.println("SE studentList: " );
        stuList.forEach(s -> System.out.println(s));
    }

}
