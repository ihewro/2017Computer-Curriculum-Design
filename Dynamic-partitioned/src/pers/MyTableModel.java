/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pers;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hewro
 */
public class MyTableModel extends AbstractTableModel{
    Object[][] Data = new String[20][5];//表中的数据
    String [] Names = {"序号","起址","大小","状态","作业ID"};
    
    /*构造函数*/
    public MyTableModel() {
    }
    
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
    
    public static void reloadJTable(MyTableModel dtm){
        System.out.println("执行了重载表格数据操作！");
        DynamicPartitioned mainInstance = new DynamicPartitioned();
        sortByPatitonAdress sortByPatitonAdress = new sortByPatitonAdress();
        Collections.sort(mainInstance.partitions, sortByPatitonAdress);
        ArrayList<Partition> tempPartitions = mainInstance.partitions;
        for (int i =0;i < tempPartitions.size(); i++){
            dtm.setValueAt(i+1+"", i, 0);
            System.out.print("当前  " + i + "分区   ");
            for (int j = 1;j < 5;j++){
                System.out.print("第" + j + "位置:" + tempPartitions.get(i).getByIndex(j) + "   ");
                dtm.setValueAt(String.valueOf(tempPartitions.get(i).getByIndex(j)), i, j);    
            }
            System.out.println("");
            
        }
        for(int i = tempPartitions.size(); i < 20;i++){
            for(int j = 0;j < 5;j++){
                dtm.setValueAt("", i, j);     
            }
        }
        //GlobalObject.getjTable().setModel(dtm);
        //table.revalidate();
        //GlobalObject.setjTable(table);
        //GlobalObject.getjScrollPane().setViewportView(table);
        
    }
    
}
