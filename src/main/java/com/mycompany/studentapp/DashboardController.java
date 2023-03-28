
package com.mycompany.studentapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Bino
 */
public class DashboardController implements Initializable {
    private final ObservableList<Student> list = FXCollections.observableArrayList();
    
    @FXML
    Button btnAdd, btnUpdate, btnSearch, btnDelete, btnLogout;
    @FXML
    TextField tfName, tfId;
    @FXML
    TableView tblData;
    @FXML
    Label lblUser, lblName, lblId, lblSuccess;
     @FXML
    private TableColumn<Student, String> colId;

    @FXML
    private TableColumn<Student, String> colName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUser.setText(LoginController.loggedinUser);
        colId.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        
        tblData.setItems(list);

    }    
    @FXML
    public void addStudent(){
        emptyChecker();
        if(!tfName.getText().equals("") && !tfId.getText().equals("")){
            Student student = new Student();
            student.setName(tfName.getText());
            student.setId(tfId.getText());
            list.add(student);
            lblSuccess.setText("Successfully Added");
            tblData.refresh();
        }
        
    }
    @FXML
    public void updateStudent(){
        for(Student s: list){
            if(s.getId().equals(tfId.getText())){
                s.setName(tfName.getText());
                s.setId(tfId.getText());
                lblSuccess.setText("Updated Successfully");
                tblData.refresh();
            }
               
        }
    }
    @FXML
    public void deleteStudent(){
        for(Student s: list){
            if(s.getId().equals(tfId.getText())){
                System.out.println("true"+s.getId());
                list.remove(s);
                lblSuccess.setText("Deleted Successfully");
                tblData.refresh();
            }
        }
    }
    
    @FXML
    public void searchStudent(){
        int found = 0;
        for(Student s: list){
            if(s.getId().equals(tfId.getText())){
                tfName.setText(s.getName());
                tfId.setText(s.getId());
                found=1;
            }
        }
        if(found==0){
                lblId.setText("No student found with ID No - "+tfId.getText());
            }
    }
    @FXML
    public void logout() throws IOException{
        App.sceneFactory("/fxml/login");
    }
    
    private void emptyChecker() {
       if(tfName.getText().equals(""))
            lblName.setText("Please enter Full Name");
        else
            lblName.setText("");
        if(tfId.getText().equals(""))
            lblId.setText("Please enter Full Name");
        else
            lblName.setText("");
    }
}
