

package com.exam.mdj;

import java.util.ArrayList;
import java.util.Random;

public class MDG {

    Random rand;
    public boolean isValidMDG(int[][] mdg){
        if(mdg!=null){
            if(mdg.length!=0){
                if(mdg[0]!=null&&mdg[0].length!=0&&mdg[0].length==mdg.length){
                    for (int[] mdg1 : mdg) {
                        if (mdg1 == null) {
                            return false;
                        }
                    }
                    return true;
                }else{
                    return false;
                }
            }else{
                throw new ArrayIndexOutOfBoundsException("MDG size can't be empty");
            }
        }else{
            throw new NullPointerException("MDG can't be null");
        }
    
    }
    
    public ArrayList<Integer> initStartingPoint(int mdgSize){
        
        if(mdgSize==0){
            throw new ArithmeticException("Size cant be zero.");
        }
        ArrayList<Integer> clusters=new ArrayList<>();
        for(int i=0;i<clusters.size();){
            clusters.set(i, i+1);
        }
        return clusters;
    }
    
    public int fitness(ArrayList<Integer> c,int[][] m){
        if(c==null){
            throw new NullPointerException("Cluster can't be null");
        }else if(c.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Cluster can't be empty");
        }
        int EVM=0;
        for(int i=0;i<m.length-1;i++){
            for(int j=i+1;j<m.length;j++){
                int c1=c.get(i);
                int c2=c.get(j);
                if(c1==c2){
                    EVM+=2*m[i][j]-1;
                }
            }
        }
        return EVM;
    }
    
    public ArrayList<Integer> smallChangeOperator(ArrayList<Integer> c){//moves cluster items randomly
        if(c==null){
            throw new NullPointerException("Cluster can't be null");
        }else if(c.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Cluster can't be empty");
        }
        
        int[] randomArr;
        randomArr=getRandomNumbers(c);
        c.set(randomArr[0], randomArr[1]);
        return c;
    }
    public ArrayList<Integer> munch(int iter,int[][] M){
        if(isValidMDG(M)){
            if(iter==0){
                throw new ArithmeticException("Iterations should be greater than Zero.");
            }
            ArrayList<Integer> c=initStartingPoint(M.length);
            int F=fitness(c, M);
            for(int i=0;i<iter;i++){
                int[] randomArr=getRandomNumbers(c);
                int temp=c.get(randomArr[0]);
                c.set(randomArr[0], randomArr[1]);
                int cF=fitness(c, M);
                if(cF<F){
                    c.set(randomArr[0], temp);
                }else{
                    F=cF;
                }
            }
            return c;
        }else{
            return null;
        }
    }

    private int[] getRandomNumbers(ArrayList<Integer> c) {
        int r1,r2;
        r1=UI(1,c.size());
        do{
        r2=UI(1,c.size());
        }while(c.get(r1)==r2);
        return new int[]{r1,r2};
    }
    public int UI(int aa,int bb)
	{
		int a = Math.min(aa,bb);
		int b = Math.max(aa,bb);
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return(x);
	}
}