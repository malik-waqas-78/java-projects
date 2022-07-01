/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temp;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        MDG mdg=new MDG();
        int mat[][]={
            {1,2},
            {3,4}
        };
        ArrayList<Integer> c=mdg.munch(8, mat);
        for(int x:c){
            System.out.println(x);
        }
    }
}
