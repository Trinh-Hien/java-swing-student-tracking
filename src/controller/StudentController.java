/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.StudentModel;

/**
 *
 * @author PC
 */
public class StudentController {
    private final JTable tbStudent;
    private final JTextField tfSearch;
    private final JButton btAdd;
    private final JButton btExport;
    private final StudentModel studentModel;
    

    public StudentController(JTable tbStudent, JTextField tfSearch, JButton btAdd, JButton btExport) {
        this.tbStudent = tbStudent;
        this.tfSearch = tfSearch;
        this.btAdd = btAdd;
        this.btExport = btExport;
        studentModel = new StudentModel();
    }

    public void loadData() {
        tbStudent.setModel(studentModel);
    }
    
    
}
