package com.chilllearn.supperapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Ta sẽ xài các CLass được cung cấp sẵn bởi JDK có trong thư viện JDBC
        //JDBC này sẽ tự động móc với SQL SERVER JDBC DRIVER
        //                              của hãng MICROSOFT giúp điểu khiển
        //                              gã vô diện SQL SERVER hậu trường
        //Tương tự cho MYSQL, ta cx cần thêm driver

        Connection conn = null;
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "12345";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// =>JDBC tự động đi tìm SQL server driver hoặc MySQL DRIVER (thông qua dấu hiệu trong URL ở trên) nên ko cần dòng này nửa
            conn = DriverManager.getConnection(dbURL, user, pass);
            //DriverManager là tk điểu khiển trình kết nối bằng các dữ liễu đã đc đưa(dbURL, user,pass)
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") là tk b nguyên dependency vào Driver đe73 Driver quản lý, DriverManager sẽ kết nào vào tk Driver này(Đi vào trong database) lthì lúc này Connection được tạo ra(tk duy trì cái kết nối này)
            System.out.println("Connect to DB successfully");

            //kết nối thành công vô diện - SERVER hậu trường thì bắt đầu mốc nối với table qua câu sql
            //Tạo Class PreparedStatementn dùng để quản lý câu SQL (WHERE, tham số):
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Subject");
            ResultSet rs = stm.executeQuery();//thực thi câu SQL và trả về ResultSet
            //=>giống ArrayList, chứa nhiều dòng/record, mỗi dòng là info của môn học
            //Code | Name | Desc | Credits | StudyHours
            //CHƠI VỚI JDBC THÌ PHẢI NHỚ TÊN CỘT!!!! MANG HƠI HƯỚNG DB FIRST, DB ORIENTED
            //VÒNG LẶP LẤY CÁC DÒNG, MỖI DIÒNG CHỦ ĐỘNG NHỞ TÊN CỘT TABLE, LẤY CỘT
            //=> NHƯỢC ĐIỂM CỦA JDBC THUẦN
            while (rs.next()) {
               String code = rs.getString("Code");//tên cột là gì, datatype của tên cột là gì, phải nhớ mới lấy được
               String name = rs.getString("Name");
               String Description = rs.getString("Description");
               int credits = rs.getInt("Credits");
               int hours = rs.getInt("StudyHours");
               //In theo kiểu ghép:
                //System.out.println(code + " " + name + " " + credits + " " + hours);
                //In giống lề:
                System.out.printf("|%10s|%-40s|%2d|%4d|\n", code, name, credits, hours);
                //conn.close();//chơi ngoo, tắt kết nối khi in dòng đầu tiên
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}