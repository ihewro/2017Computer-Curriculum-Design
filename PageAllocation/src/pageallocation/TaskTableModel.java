/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageallocation;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hewro
 */
public class TaskTableModel extends AbstractTableModel {
    Object[][] Data = new Object[64][3];//表中的数据
    String [] Names = {"已经分配的作业ID","页号","块号"};

    @Override
    /*获取列名称*/
    public String getColumnName(int column)
    {   
        
	return Names[column];
    }
    @Override
    /*获取列数目*/
    public int getColumnCount() {
	// TODO 自动生成的方法存根
	//得到表格列数
        //System.out.println("列数目" + Names.length);
	return Names.length;
    }

    @Override
    /*获取行数目*/
    public int getRowCount() {
	// TODO 自动生成的方法存根
	//得到表格行数
        //System.out.println("行数目" + Data.length);
	return Data.length;
    }

    @Override
    /*获取某一位置的值*/
    public Object getValueAt(int rowIndex, int columIndex) {
	// TODO 自动生成的方法存根
	return Data[rowIndex][columIndex];
    }
    @Override
    /*设置某一位置的值*/
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
	Data[rowIndex][columnIndex] = (String) aValue;
	/*通知监听器数据单元数据已经改变*/
	fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public static void reloadJTable(TaskTableModel dtm,int taskID){
        ArrayList<Task> tasks = PageAllocation.tasks;
        for (int i = 0;i < tasks.size();i++){
            dtm.setValueAt(String.valueOf(tasks.get(i).getTaskID()), i, 0);
            
            if (taskID == -1) {
                for (int j = 0; j < 64; j++) {
                    dtm.setValueAt("", j, 1);//页号
                    dtm.setValueAt("", j, 2);//块号
                }
            }else{
                if (tasks.get(i).getTaskID() == taskID) {
                    for (int j = 0; j < tasks.get(i).getPageNums(); j++) {
                        dtm.setValueAt(String.valueOf(j), j, 1);//页号
                        System.out.println("当前作业页号为" + j);
                        dtm.setValueAt(String.valueOf(tasks.get(i).getBlockArrayList()[j]), j, 2);
                        System.out.println("当前作业块号为" + tasks.get(i).getBlockArrayList()[j]);             
                    }
                    for (int k =tasks.get(i).getPageNums();k<64;k++){
                        dtm.setValueAt("", k, 1);//页号
                        dtm.setValueAt("", k, 2);//块号
                    }
                    
                }//end of if 
            }
           
        }
        for (int m = tasks.size();m <64;m++){
            dtm.setValueAt("", m, 0);
        }
    }
    
}
