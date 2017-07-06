/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageallocation;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hewro
 */
public class BigmapTableModel extends AbstractTableModel {
    int[][] Data = new int[8][9];//表中的数据
    String [] Names = {"行号/列号","0","1","2","3","4","5","6","7"};

    public BigmapTableModel() {
        for (int i = 0;i<8;i++){
            Data[i][0] = i;
        }
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
	Data[rowIndex][columnIndex] = (int) aValue;
	/*通知监听器数据单元数据已经改变*/
	fireTableCellUpdated(rowIndex, columnIndex);
    }
    public static void reloadJTable(BigmapTableModel dtm){
        int[]bigmap = PageAllocation.bitmap;
        for (int i = 0;i<64;i++){
            int row = i/8;
            int colum = i%8 + 1;
            dtm.setValueAt(bigmap[i], row, colum);
        }
    }
}
