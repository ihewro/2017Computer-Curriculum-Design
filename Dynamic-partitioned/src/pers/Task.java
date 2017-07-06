/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pers;

/**
 *
 * @author hewro
 */
public class Task {
    public int size;
    public String taskName;

    public Task(int size, String taskName) {
        this.size = size; 
        this.taskName = taskName;
    }
    
    /*getting methods*/
    
    int getSize(){
        return this.size;
    }
    String getTaskName(){
        return this.taskName;
    }



    /*setting methods*/
    void setSize(int size){
        this.size = size;
    }
    
    void setTaskName(String name){
        this.taskName = name;
    }
    
    void setForAll(String name, int size){
        this.taskName = name;
        this.size = size;
    }
    
    /*others methods*/
    
    
}
