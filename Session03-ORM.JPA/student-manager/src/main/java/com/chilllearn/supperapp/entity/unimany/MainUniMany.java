package com.chilllearn.supperapp.entity.unimany;

import com.chilllearn.supperapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniMany {

    public static void main(String[] args) {
        createMajorStudents();
    }

    public static void createMajorStudents(){
        Major se = new Major("SE", "SOFTWARE ENGINEERING | KĨ THUẬT PHẦN MỀM");
        Student an = new Student("SE100", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE101", "BÌNH LÊ", 2004, 8.7);
        an.setMajor(se);
        binh.setMajor(se);//2tk vaò chuyên ngành, nếu ko là 2 chúng ta ko thuộc về Major

        //XUống DB phải nhờ JpaUtil:
        EntityManager en = JpaUtil.getEntityManager();
        en.getTransaction().begin();
        en.persist(se);//Lưu Major trc
        en.persist(an);//Lưu Student sau và ko đổ Domino đc
        en.persist(binh);//Domino chỉ dành cho 1 -> N, áp dụng cho 1 đám bị ảnh hưởng bởi..., 1 Major, áp dụng chung cho 1 nhóm students
        en.getTransaction().commit();//Cực kì quan trọng, chính thức SAVE thật, ổn định xuống DB
        en.close();
    }

}
