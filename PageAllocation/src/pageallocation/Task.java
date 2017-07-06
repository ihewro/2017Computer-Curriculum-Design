/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageallocation;

import java.util.ArrayList;

/**
 *
 * @author hewro
 */
public class Task {
    int taskID;
    int [] BlockArray = new int[64];
    public static int pageNums;

    public Task(int taskID,int pageNums) {
        this.taskID = taskID;
        this.pageNums = pageNums;
    }
    
    
    int[] getBlockArrayList(){
        return this.BlockArray;
    }
    
    int getPageNums(){
        return Task.pageNums;
    }
    int getTaskID(){
        return this.taskID;
    }
    
    void setPageArrayList(){
        
    }
    void setBlockArrayList(){
        
    }
    void setTaskID(int taskID){
        this.taskID = taskID;
    }
    void setPageNums(int pageNums){
        this.pageNums = pageNums;
    }
}
