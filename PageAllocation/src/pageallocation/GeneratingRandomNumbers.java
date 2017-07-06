/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageallocation;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hewro
 * discription: generate random numbers
 */
public class GeneratingRandomNumbers {
    public static ArrayList<Integer> randomNumbers = new ArrayList <Integer>();
    
    public static int generate(){
        int result = 0;
        while(true){
            Random random = new Random();
            int i1 = random.nextInt(9);
            int i2 = random.nextInt(9);
            int i3 = random.nextInt(9);
            result = i1 + i2*10 + i3*100;
            int flag = 0;
            for(int i =0;i<randomNumbers.size(); i++){
                if (result!=randomNumbers.get(i)) {
                    flag++;
                }else{
                    break;
                }
            }
            if (flag == randomNumbers.size()) {
                randomNumbers.add(result);
                break;
            }
        }
        return result;
    }
    
    
}
