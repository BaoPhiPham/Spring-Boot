package com.chilllearn.fap.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//Getter, Setter, ToString cố thể khai báo 1 dòng @Data là đc

public class Student {
    private String id;
    private String name;
    private int yob;
    private double gpa;

    //ĐOẠN CODE BOILER PLATE NHÀM CHÁN
    // => Ta ko thèm làm theo cách truyền thống, nhưng vnẫ phải làm theo 1 cách nào đó -> ta dùng thêm 1 thư viện trên mạng giúp ta GENERATE đám này 1 cách tự động -> LOMBOK DEPENDENCY
    //LAMBOK là hàng của ae mạng, ko phải chính hãng của JDK
    //C# thì có hàng chính hãng -> gọi là kĩ thuật Property có sẵn trong .NET SDK
    //Ta đi tải thư viện LOMBOK qua file POM.XML
    //THư viện tự được add vào project, ta chỉ việc xài các class có sẵn trong thư viện tải về!!!
    //Lên kho tổng MVNREPOSITORY.COM -> Tìm thư viện, tìm hồ sơ add vào pom.xml -> CLICK CRTL -> SHIFT -> 0 để tải và add
    //ĐI thi PE xin khảo thí, giám thị cho mình vào internet để đồng bộ thư viện
}
