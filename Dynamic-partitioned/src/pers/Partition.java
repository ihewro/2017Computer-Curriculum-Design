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
public class Partition implements Comparable<Partition> {
    public int startAddress;
    public int size;
    public int status; /* 0代表未分配，1代表已分配 */
    public Task task;
    
    /*getting methods*/
    
    Object getByIndex(int index){
        switch (index){
            case 1: return this.startAddress;
            case 2: return this.size;
            case 3: return this.status;
            case 4: return this.task.getTaskName();
            default: return null;
        }
            
    }
    int getSize(){
        return this.size;
    }
    
    int getStartAdress(){
        return this.startAddress;
    }
    
    int getStatus(){
        return this.status;
    }
    
    Task getTask(){
        return this.task;
    }
    
    /*setting methods*/
    
    void setforAll(int startAdress, int size, int status, Task task){
        this.startAddress = startAdress;
        this.size = size;
        this.status = status;
        this.task = task;
    }
    
    void setSize(int size){
        this.size = size;
    }
    
    void setStartAddress(int startAddress){
        this.startAddress = startAddress;
    }
    
    void setStatus (int status){
        this.status = status;
    }
    
    void setTask(Task task){
        this.task = task;
    }
    
    /*other methods*/
    
    @Override
    public int compareTo(Partition arg0) {
        arg0 = (Partition)arg0;
        if (this.size > arg0.getSize()) {
            return 1;
        }else if (this.size < arg0.getSize()) {
            return -1;
        }else{
            return 0;
        }
    }
}
