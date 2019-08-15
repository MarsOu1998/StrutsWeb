package DAO;

import Bean.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {
    public ArrayList getAllStu(){
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/letterwish?characterEncoding=UTF8";
        String user="root";
        String pass="Oushile123.";
        Connection conn;
        Statement stm;
        ArrayList student=new ArrayList();
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,pass);
            stm=conn.createStatement();
            String sql="select * from user";
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()) {
                Student student2=new Student();
                student2.setName(rs.getString("name"));
                student2.setSex(rs.getString("sex"));
                student2.setAge(rs.getString("age"));
                student2.setAccount(rs.getString("account"));
                student.add(student2);
            }
            rs.close();
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;

    }
}
