package com.chilllearn.supperapp;

import com.chilllearn.supperapp.entity.Lecturer;
import com.chilllearn.supperapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.chilllearn.superapp-PU");

    public static void main(String[] args) {
//        insertStudents();//tạo bảng, chèn data qua oop code first
//        getAllStudents();//select * from style OOP, code first
//        insertLecturers();
//        getAllLecturers();
//        searchLecturers();
//        findbyId();
        update();
        findbyId();
    }

    public static void update(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Lecturer x = em.find(Lecturer.class, 5   );
        Student y = em.find(Student.class, "SE2"   );
        x.setSalary(25_000_000);
        y.setGpa(9.2);
        em.getTransaction().commit();//khoá sổ 2 hành động
        System.out.println("UPDATE SUCCESSFULLY!!!");
        em.close();
    }

    //Khi làm các haành động xóa, sửa , thêm ảnh hưởng và thay đổi hiện trạng DB
    //Ta phải nhét nó vào TRANSACTION để theo dõi: hoặc tất cả, hoặc ko gì cả
    //TRANSACTION là theo dõi dấu vết, đẩm bảo giao dịch đc hoàn tất
    //Nuyên lí DO ALL OR NOTHING: ACID
    public static void remove(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Lecturer x = em.find(Lecturer.class, 2   );
        Student y = em.find(Student.class, "SE1"   );
        em.remove(x);
        em.remove(y);
        em.getTransaction().commit();//khoá sổ 2 hành động
        System.out.println("DELETE SUCCESSFULLY!!!");
        em.close();
    }

    //EntityManager là ô xếp quản lý các Entity ~ chính là class có từ khóa có @Entity và quản lý class object tạo từ Class ENtity: sếp có thể thêm persist(); xóa remove(); update merge(); tìm theo PK find(), v ta luôn có nhu cầu thao tác trên 1 dòng/row/record cụ thể trong table
    //SWP admin, có màn hình quản lí user, phân loại, show table có nhiều dòng, phân trang, filter, cuối dòng có cột Actrions: Update | Delete -> xử lý đúng 1 dòng đang select --> theo PK
    //Ngoài ra có hàm creteQuery() để tìm linh hoạt theo cái tổ hợp điều kiện nào đó
    public static void findbyId(){
        EntityManager em = emf.createEntityManager();
        //Tìm theo key th2i chỉ trả ra 1 record
        Lecturer x = em.find(Lecturer.class, 5   );//1 là giá trị PK muốn tìm
        Student y = em.find(Student.class, "SE2"   );//id của Student là chuỗi
        System.out.println("Lecturer infor:  " + x);
        System.out.println("Student infor:  " + y);
        em.close();
    }

    //SPRING DATA, SPRING JPA

    //Học thêm về JPQL: JAVA PERSISTENCE QUERY LANGUAGE - là phiên bản độ từ SQL nhưng dành cho thế giới OOP, OBJECT
    //HIBERNATE cx có phiên bản riêng nửa của nó gọi là HQL - HIBERNATE QUERY LANGUAGE
    //SQL truyền thống: SELECT * FROM LECTURER
    //JPQL: FROM LECTURER
    //      SELECT lec FROM LECTURER lec
    //                      với mỗi dòng/record lấy từ table Lecturer
    //                      ta new nó trong RAM, new Lecturer() và lọi vùng RAM này là lec,
    //                      tức là lec = new Lecturer() và lặp lại cho toàn bộ record
    //                      trong table Lecturer
    //ADD kết quả đọc từ table vào kết quả cuối cùng dùng lệnh SELECT lec
    //SELECT lec tức là lấy từng OBJECT lec đc new từ từng dòng trong table Lecturer
    //lec là 1 biến, 1 bí danh, đại cho các OBJECT đc new từ Table

    //WHERE
    //SQL: SELECT * FROM LECTURER WHERE Salary = '20000000' // tên cột trong Table, SQL Server ko phân biệt hoa thường nên ta select thì thường hay hoa đều đc
    //JPQL: SELECT x FROM LECTURER x WHERE x.salary = 20000000// tên field trong Class - đúng chuẩn camalcase, ko đc viết hoa tên field như trong DB vì ta đang chs vs oop, object;
    //      x. là biến OBJECT Nha!!!! ko phải tên cột trong Table!!!! => thuần chs vs OOP, code
    //QUERY động tham số WHERE: truyền từ WEB PAGE/FORM -> đến đây có 1 VALUE nào đó
    //  -> JPQL: SELECT x FROM Lecturer x WHERE x.salary = :pSalary // pSalary là parameter Salary
    //Có quyền dùng thêm And, OR như SQL chuẩn
    //Có quyền dùng toán tử LIKE so sánh gần đúng giá trị chuỗi
    // + SQL chuẩn: SELECT * FROM LECTURER WHERE Name LIKE '%An%' -- Tên chứa chữ An
    //                                                      'An%' -- Tên bắt đầu bằng chữ 'An'
    // + PSQL: SELECT lec FROM Lecturer lec WHERE lec.name LIKE :pName
    //          setParameter("pName", "%An%").setParameter()  vì lúc này vẫn là tạo câu Query

    public static void searchLecturers(){
        EntityManager em = emf.createEntityManager();

//        List<Lecturer> lecturers = em.createQuery("SELECT x FROM Lecturer x WHERE x.salary = :pSalary", Lecturer.class).setParameter("pSalary", 20_000_000) .getResultList();
        //Nếu hàm trả về Object thì ta có quyền chấm tiếp thay vì khai báo 1 biến để hứng sau đó biến chấm tiếp

        List<Lecturer> lecturers = em.createQuery("SELECT x FROM Lecturer x WHERE x.yob = :pYob", Lecturer.class).setParameter("pYob", 1991) .getResultList();

        System.out.println("THe list of lecturers printed by lambda expression: ");
        lecturers.forEach(x -> {
            System.out.println(x);
        });
        em.close();
    }

    public static void insertLecturers(){
        //Lôi cổ ô xếp quản lý các Entity ra để tạo table, chèn data vào table Lecturers - option XML create, hay update đều mlem!!!
        //Đi làm thật, cấm OPTION "create" trên máy khách hảng nếu ta fix bug, update APP
        //Vì taong hết data khách hàng!!!
        Lecturer an = new Lecturer("An Nguyễn", 1990, 20_000_000);
        Lecturer binh = new Lecturer("Bình Lê", 1991, 20_000_001);
        //Nhớ luôn validation số tiền khi lưu database và code

        EntityManager em = emf.createEntityManager();
        //Vì có thay đổi CSDL(Table, Data) nên ta cần thay đổi chặt chẽ các câu lệnh -> Dùng khái niệm Transaction: Do ALL OR NOTHING
        //Hoặc tất cả, hoặc ko gì cả. Ngyên lý ACIT của Transaction
        //Ví DỤ: Bạn chuyển tiền trả nợ tk bạn 1 triệu đồng
        //Từ TP Bank (của mình) sang ACB (của bạn)
        //TP BANK -1M và ACB +1M  => cả 2 phải xảy ra mới OkE
        //Rớt 1 trong 2, ROLLBACK, hoặc tất cả, hoặc chưa gì cả!!!
        //Bên TP BACK khởi động ngay TRANSACTION theo dõi
        //Mình đã -1M, mãi ch thấy bên kia nói OKE -> nhà mình UNDO!!!
        em.getTransaction().begin();//bắt đầu theo dõi sự thay đổi của DB
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit();//khóa sổ, hoặc 2 OBject xuống DB, hoặc ko ai cả
        em.close();
    }

    public static void getAllLecturers(){
        EntityManager em = emf.createEntityManager();
        //luoôn cần có ô quản lý các Entity
        //Viết câu sql style Object, jọi là JPQL, HQL khá giống SQL truyền thống, nhưng là làm việc, select, thao tác trên Object , trên cái Class Entity chứ ko quan tên tên cột trong Table như JDBC đã làm
        List<Lecturer> lecturers = em.createQuery("SELECT x FROM Lecturer x WHERE x.salary = 20000001", Lecturer.class).getResultList();//so sánh số trong DB thì nên viết chuẩn số
        //Quan trọng: Ở đây không phải là tên bảng trong DB (lecturers), mà là tên Entity class đã được khai báo với @Entity. Nếu bạn viết "FROM LECTURERS", Hibernate sẽ báo lỗi nếu không có entity nào tên LECTURERS
        //Lecturer là Class, từ đó sinh ra Object, Class Lecturer đã map thành table Lecturers ở bên khia báo @Entity
        System.out.println("The list of Lecturers (" + lecturers.size() + ") records: ");
//        for (Lecturer lecturer : lecturers) {//toán tử với mọi - chữ A ngc trong toán học
//            System.out.println(lecturer);
//        }
        System.out.println();
        //Biểu thức LAMBDA - LAMBDA EXPRESSION, dính dáng ccự kì chặt chẽ với STREAM API, cơ chế xử lí nhiều dữ liệuở trong RAM
        //LAMBDA EXPRESSION là hàm vô danh, hàm ẩn danh!!! Hàm` ko có tên
        //DÍnh đến khái niệm lập trình hàm - FUNCTIONAL PROGRAMMING
        //Hàm là 1 DATA, và hàm là tham số để truyền vào hàm khác
        System.out.println("THe list of lecturers printed by lambda expression: ");
        lecturers.forEach(x -> {
            System.out.println(x);
            // ko thèm In x, làm chơi trò khác
//            System.out.println("list of numbers from 1 to 100");
//            for (int i = 1; i <= 100; i++) {
//                System.out.print(i + " ");
//            }
        });
        em.close();
        emf.close();//sau getAll mà ko làm gì nửa thì close luôn connection, ko close thì tốn RAM
    }

    //Insert tạo mới sinh viên:
    public static void insertStudents(){
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.chilllearn.superapp-PU");// => gửi thông số cấu hình server; Provider JPA: Hibernate; nhà thầu JDBC cho JPA Class nó lo để tạo kết nối tới cơ sở dữ liệu cụ thể SQL Server
        EntityManager em = emf.createEntityManager();
        // Tạo ra 1 object dùng để quản lí các Entity Class ~ map ngang sang Table. Class Student chịu sự quản lý của em/EntityManager
        // em/EntityManager  sẽ lo CRUD trên 1 Table nào đó!!!
        // qua mấy hàm huyền thoại: persit(), find(), merge(), remove()
        // => Toàn chơi Object, đằng sau là Table bị ảnh hưởng - tụ sinh SQL ngầm, và nó cho mình thấy câu SQL này luôn khi mình chấm các hàm ở trên .persit(), .find(), .merge(), .remove()

        //Chuẩn bị data Student - Object nha - OOP nha
        Student an = new Student("SE1", "An Nguyễn", 2004, 8.6);
        Student binh = new Student("SE2", "Bình Lê", 2004, 8.7);
        Student cuong = new Student("SE3", "Cường Võ", 2004, 8.8);
        //tới đây vẫn chưa c Table Student trong DB

        //Gọi xếp EntityManager giúp CRUD
        em.getTransaction().begin();//bắt buộc phải có transaction khi có sự thay đổi trong DB
        em.persist(an);//Create table diễn ra ngầm => gọi là code first, code ra table, code ra data
        em.persist(binh);
        em.persist(cuong);

        //insert into student Values
        em.getTransaction().commit();//hoặc 3 đứa imseret thành công, hoặc chưa bạn nào đc insert
        //SELECT Ko cần vì ko thay đổi DB
        em.close(); //sa thải ô xếp vì đã xong
        //emf.close();//ngắt kết nối csdl vì đã xong
        // => trong trường hợp persitence là create nên emf.close() để đóng khi app shutdown, logout webapp
    }

    //SELECT * FROM để lấy hết Data:
    public static void getAllStudents(){
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.chilllearn.superapp-PU");
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("FROM Student", Student.class).getResultList();//hậu trường là SELECT * FROM Student của SQL truyền thống - sẽ in ra xem nếu khai báo cấu hình trong file xml

        //Query này cú pháp gần giống SQL, theo Style OOP, có Object và có dấu chấm, gọi là JPQL, HQL

        System.out.println("The list of students is :");
        for (Student student : students){
            System.out.println(student);
        }
        //dùng biểu thức lambda để in cx đc
        em.close();
//        emf.close();
    }
}