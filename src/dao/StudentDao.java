/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.StudentStatus;
import entities.Student;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectToMySQL;

/**
 *
 * @author PC
 */
public class StudentDao {
    private final Connection con = ConnectToMySQL.getConnectMySQL();
    private Statement st;
    private ResultSet rs;
    
    public List<Student>  getStudent(){
        List<Student> students= new ArrayList<>();
        final String query="select * from student";
        try {
            st=con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
               students.add(new Student(rs.getInt("STUDENT_ID"), rs.getString("FULLNAME"), rs.getBoolean("GENDER")
                       ,getDateOfBirth(rs.getDate("DATE_OF_BIRTH")) , rs.getString("PHONE"), rs.getString("EMAIL"),
                       rs.getString("FLINK"), rs.getString("WORK_PLACE"), rs.getString("ADDRESS"), rs.getString("DESCRIPTION"),
                       getStudentStatus(rs.getString("STATUS"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }
    public LocalDate getDateOfBirth(Date date){
        if(date == null){
            return null;
        }else{
            return date.toLocalDate();
        }
    }
    public StudentStatus getStudentStatus(String input){
        StudentStatus status= null;
        switch(input){
            case "Đã hoàn thành":
                status = StudentStatus.DONE;
                break;
            case "Đang theo học":
                status = StudentStatus.INPROGRESS;
                break;
            case "Tạm dừng":
                status = StudentStatus.DISCARD;
                break;
            case "Đợi khóa sau":
                status = StudentStatus.WAITING;
                break;        
        }
        return status;
    }
    
    
}
