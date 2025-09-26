/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author uthum
 */
public class courseData {
    
    private String course;
    private String description;
    private String degree;
    
    public courseData(String course, String description, String degree){
        this.course = course;
        this.description = description;
        this.degree = degree;
    }
    
    public String getCourse(){
        return course;
    }
    public String getDescription(){
        return description;
    }
    public String getDegree(){
        return degree;
    }
    
    
}
