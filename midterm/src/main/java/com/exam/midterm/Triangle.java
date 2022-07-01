
package com.exam.midterm;






public class Triangle {
    
    private static final int SIZE=51;
    
    public static void main(String[] args) {
        boolean mat[][]=new boolean[SIZE][SIZE];
        int x1,y1,x2,y2,x3,y3;
        
        java.util.Scanner scan =new java.util.Scanner(System.in);
        while(true){
            System.out.println("Enter value for X1 :");
            x1=scan.nextInt();
            System.out.println("Enter value for Y1 :");
            y1=scan.nextInt();
            System.out.println("Enter value for X2 :");
            x2=scan.nextInt();
            System.out.println("Enter value for Y2 :");
            y2=scan.nextInt();
            System.out.println("Enter value for X3 :");
            x3=scan.nextInt();
            System.out.println("Enter value for Y3 :");
            y3=scan.nextInt();

            if(x1==0&&y1==0&&x2==0&&y2==0&&x3==0&&y3==0){
                break;
            }
            
            mat=clearMatrix(mat);

            mat=drawLine(mat, x1, y1, x2, y2);

            mat=drawLine(mat, x1, y1, x3, y3);
            
            mat=drawLine(mat, x2, y2, x3, y3);
            
            printMarix(mat);
        
        }
    }
    
    public static boolean[][] clearMatrix(boolean[][] mat){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                mat[i][j]=false;
            }
        } 
        
        return mat;
    }
    
    public static boolean[][] drawLine(boolean[][] mat,int x1,int y1,int x2,int y2){
      if(java.lang.Math.abs(y2-y1)<java.lang.Math.abs(x2-x1)){
          if(x1>x2){
              mat=drawLineLow(mat, x2, y2, x1, y1);
          }else{
              mat=drawLineLow(mat, x1, y1, x2, y2);
          }
      }else{
          if(y1>y2){
              mat=drawLineHigh(mat, x2, y2, x1, y1);
          }else{
              mat=drawLineHigh(mat, x1, y1, x2, y2);
          }
      }
      return mat;
    }
    
    public static boolean[][] drawLineLow(boolean[][] mat,int x1,int y1,int x2,int y2){
        
        float dx=x2-x1;
        float dy=y2-y1;
       
        for(int x=x1;x<x2;x++){
            
            float y=y1+dy*(x-x1)/dx;
            mat=mark(mat,(int)x,(int)y);
        
        }
        
        return mat;
    }
    public static boolean[][] drawLineHigh(boolean[][] mat,int x1,int y1,int x2,int y2){
        
        float dx=x2-x1;
        float dy=y2-y1;
        
        for(int y=y1;y<y2;y++){
            
            float x=x1+dx*(y-y1)/dy;
            mat=mark(mat,(int)x,(int)y);
        
        }
        
        return mat;
    }    
    public static boolean[][] mark(boolean[][] mat,int x,int y){
        mat[x][y]=true;
        return mat;
    }
    
    public static void printMarix(boolean[][] mat){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(mat[i][j]){         
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}


