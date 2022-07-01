
package com.exam.midterm;






public class Matrix {
    
    
    
    public static void main(String[] args) {
        java.util.Scanner scanner =new java.util.Scanner(System.in);
        int x0,y0,x1,y1,x2,y2;
        boolean mat[][]=new boolean[51][51];
        do{
            
        
            x0=scanner.nextInt();
        
            y0=scanner.nextInt();
        
            x1=scanner.nextInt();
        
            y1=scanner.nextInt();
        
            x2=scanner.nextInt();
       
            y2=scanner.nextInt();
        
            if(x0==0&&y0==0&&x1==0&&y1==0&&x2==0&&y2==0){
                break;
            }
            
            clearMatrix(mat);
            
            drawLine(mat, x0, y0, x1, y1);//lie from point 1 to point 2
        
            drawLine(mat, x0, y0, x2, y2);//line from point 1 to point 3
            
            drawLine(mat, x1, y1, x2, y2);//line from point 2 to point 3
            
            printMarix(mat);
        
        }while(true);
    }
    
    public static boolean[][] clearMatrix(boolean[][] mat){
        for (boolean[] matx : mat) {
            for (int j = 0; j<matx.length; j++) {
                matx[j] = false;
            }
        } 
        
        return mat;
    }
    
    public static void drawLine(boolean[][] mat,int x1,int y1,int x2,int y2){
        float dx=x2-x1;
        float dy=y2-y1;
        
        float absDx=dx<0?dx*(-1):dx;
        float absDy=dy<0?dy*(-1):dy;
        
        
        if(absDy<absDx&&x1>x2){
            
            int temp=x1;
            x1=x2;
            x2=temp;
            temp=y1;
            y1=y2;
            y2=temp;
            dx=x2-x1;
            dy=y2-y1;
       
            for(int x=x1;x<x2;x++){
                float y=y1+dy*(x-x1)/dx;
                mark(mat,x,(int)y);
            }
            
        }else if(absDy<absDx&&x1<x2){
            
            for(int x=x1;x<x2;x++){
                float y=y1+dy*(x-x1)/dx;
                mark(mat,x,(int)y);
            }
            
        }else if(absDy>absDx&&y1>y2){
            
            int temp=x1;
            x1=x2;
            x2=temp;
            temp=y1;
            y1=y2;
            y2=temp;
            dx=x2-x1;
            dy=y2-y1;
            
            for(int y=y1;y<y2;y++){
                float x=x1+dx*(y-y1)/dy;
                mark(mat,(int)x,(int)y);
            }
            
        }else if(absDy>absDx&&y1<y2){
            
            for(int y=y1;y<y2;y++){
                float x=x1+dx*(y-y1)/dy;
                mark(mat,(int)x,(int)y);
            }   
            
        }

    }
    
    public static void mark(boolean[][] mat,int x,int y){
        mat[x][y]=true;
    }
    
    public static void printMarix(boolean[][] mat){
        for (boolean[] matx : mat) {
            for (boolean matxy :matx) {
                if (matxy) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}

