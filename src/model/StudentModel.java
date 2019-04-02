/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Student;
import dao.StudentDao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class StudentModel extends AbstractTableModel{

    private final List<Student> students;
    private String[] cols= {"STT", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Nơi công tác", "Tình trạng"};

    public StudentModel() {
        students = new StudentDao().getStudent();
    }
    
    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    // set attribute to name in array
    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Integer.class;
        }
        if(columnIndex==3){
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value= null;
        Student student = students.get(rowIndex);
        switch(columnIndex){
            case 0:
                value=student.getId();
                break;
            case 1:
                value=student.getFullname();
                break;
            case 2:
                value=student.getDateOfBirth();
                break;
            case 3:
                value=student.isGender();
                break;
            case 4:
                value=student.getPhone();
                break;
            case 5:
                value=student.getWorkplace();
                break;
            case 6:
                value=student.getStatus().getValue();
                break;
        }
        return value;
    }
    
}
