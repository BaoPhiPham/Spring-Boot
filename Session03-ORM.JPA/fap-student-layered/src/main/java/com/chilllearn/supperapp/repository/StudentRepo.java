package com.chilllearn.supperapp.repository;

import com.chilllearn.supperapp.entity.Student;
import com.chilllearn.supperapp.infra.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepo {

    //Class này sẽ chứa các hàm CRUD chực tiếp TABLE STUDENT- REPO: nhà kho d liệu
    //Muốn CRUD 1 cací TABLE thì phải nhờ vả ô EntityManager đc cung cấp từ JpaUtil SINGLETON
    //FLOW: UI --- SERVICE --- REPO --- JpaUtil (Entity Manager Factory) --- TABLE

    //Các hàm CRUD  ở đây thường đặt tên ngắn gọn, hướng hành động giống câu lệnh SQL chuẩn (INSERT, UPDATE, DELETE)
    //Tên hàm gợi ý: save(), delete(), update(), remove(), find(), findAll(), findById()
    //Tùy hàm nhưng neếu có thay đổi trong table (INSERT, UPDATE, DELETE) thì haàm sẽ nhận vào Object(Insert, Update) hoặc Key, DELETE đưa OBJECT cx đc vì vào trong OBJECT get field Key để xóa
    //Nhớ phải dùng Transaction khi thay đổi data trong TABLE(INSERT, UPDATE, DELETE)

    //Hàm Insert xuống TABLE:
    public void save(Student obj){
        //gọi EM (Entity Manager)
        EntityManager em = JpaUtil.getEntityManager();//đoạn lệnh trôi nổi static{}
        //static chạy duy nhất 1 lần, khởi động heavy connection
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        //try catch khi save bị lỗi - từ từ....
        em.close();//giám đốc đã xong việc
    }

    //Hàm lấy tất cả sinh viên, dùng JPQL:
    public List<Student> findAll(){
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT s FROM Student s",Student.class).getResultList();
    }

    //Sửa thông tin SV - Cập nhật:
    public void update(Student obj){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        //merge nghĩa là tích hợp OBJ đưa vào vào trong em
        //em nó sẽ đổ ngang, copy ngang obj vào trong obj ứng với dòng trong table
        //Nếu bạn cố tình đưa obj mà key ko tồn tại trong table thì sẽ insert mới
        em.getTransaction().commit();
        em.close();
    }

    //xóa SV
    public void delete(Student obj){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }
    //overload
    public void delete(String id){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Student.class,id));
        em.getTransaction().commit();
        em.close();
    }

    //TODO AT HOME: làm thêm hàm WHERE theo tham số nào đó, FindById() trả về 1 SV

}
