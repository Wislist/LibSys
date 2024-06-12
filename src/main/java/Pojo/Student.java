package Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Student {
    public String name;
    public String password;
    public String sex;
    public String StuID;
    public int age;
    public String phone;
    public String major;
    public int dormID;
    public int bedID;

    public Student(){

    }
    public Student(String name,String password,String StuID){
        this.name=name;
        this.password=password;
        this.StuID=StuID;
    }
    public Student(String name, String password, String sex, String stuID, int age, String phone, String major, int dormID, int bedID) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.StuID = stuID;
        this.age = age;
        this.phone = phone;
        this.major = major;
        this.dormID = dormID;
        this.bedID = bedID;
    }
}
