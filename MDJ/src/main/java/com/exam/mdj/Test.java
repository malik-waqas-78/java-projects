/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.mdj;

/**
 *
 * @author malik-waqas
 */
public class Test {
     public static void main(String[] args) {
        MDG mdj=new MDG();
        System.out.println(mdj.isValidMDG(null));
        int[][] arr={null,null};
        System.out.println(mdj.isValidMDG(arr));
        int[][] a=new int[4][3];
        System.out.println(mdj.isValidMDG(a));
        
    }
}
