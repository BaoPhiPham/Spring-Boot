package com.chilllearn.supperapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    //Class này chịu chắc nhiệm kết nối CSDL thông qua đối tượng Entity-Manager-Factory, hao RAM, tốn thòi gian, performance, tài nguyên để tạo kênh kết nối với SQL server --> HEAVY CLASS
    //Nó chỉ nên đc khởi tạo sớm, 1 lần, 1 INSTANCE, 1 OBJECT, 1 vùng RAM, SINGLETON
    //Chưa klể mỗi lần nó c tạo ra, có khi nó sẽ tạo mới TABLE luôn (OPTION CREATE trong file .xml) hoặc nó SCAN lại cấu trúc TABLE xem có thay đổi gì ko đ cập nhật (OPTION UPDATE trong file .xml)

    //Kĩ thuật viết CODE mà khiên cho Class ko new lần thứ 2, ko đc new nhìu OBJECT, lỡ may gọi nhìu cái Class này, cx chỉ có 1 vùng new đc tạo ra
    //STATIC + PRIVATE CONSTRUCTOR
    // 1 Class ko có constructor thì JVM sẽ tự tạo giúp 1 cái constructor rỗng, vnẫ oke luôn
    //Cấm tạo OBJECT từ mọi CONSTRUCTOR: CLASS ko có CTOR, và CTOR rỗng mình phế luôn

    private static final EntityManagerFactory emf;
    //duy trì sự kết nối tới CSDL, đọc file persistence.xml để tạo dựng, update TABLE
    //Heavy load nằm ở biến này

    //khi bằng cách nào đó gọi/chạm đến Class JpaUtil thì tk static dưới này luôn đc gọi trc tiên:
    static{
        try {
            emf = Persistence.createEntityManagerFactory("com.chilllearn.superapp-PU");//load thông tin server từ file persistence.xml
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //chỉ chạy duy nhất 1 lần => class JpaUtil gọi 2 lần thì static này chỉ chạy duy nhất ở lần 1 còn lần 2 ko chạy nửa => SINGLETON

    //cấm new Class này
    //biến emf Factory chỉ có 1 con đg đc khởi tạo và khởi tạo 1 lần duy nhất qua đoạn lệnh trôi nổi static{} ở trên
    //=> kĩ thuật SINGLETON - 1 OBJECT HEAVY ENTITY-MANAGER-FACTORY TRONG RAM
    //=> Technical Skill
    private JpaUtil() {
    }

    //Có ô nha xưởng FACTORY rồi, đi mời các ô MANAGER về quản lý Các @Entity
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    //hàm này thì nhóm repository sẽ gọi đến nhờ vả xuống TABLE
    //vì nó là static cho nên chấm xài luôn
    //JpaUtil.getEntityManager()

    //đóng cửa nhà máy, ko cần chs với CSDL nửa, ko suy trì kết nối nửa khi APP shutdown
    public static void shutdown(){
        emf.close();
    }

}
