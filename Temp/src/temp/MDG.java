/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temp;

import java.util.ArrayList;
import java.util.Random;

public class MDG {

    Random rand;
    public boolean isValidMDG(int[][] mdg){
        if(mdg!=null){//null
            if(mdg.length!=0){// rows!=0
                if(mdg[0]!=null&&mdg[0].length!=0&&mdg[0].length==mdg.length){
                    for (int[] row : mdg) {//for each loop
                        if (row == null) {
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
        ArrayList<Integer> clusters=new ArrayList<>(mdgSize);
        for(int i=0;i<clusters.size();i++){ // i=2
            clusters.set(i, i+1);//2 3
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
        for(int j=0;j<m.length-1;j++){
            for(int k=j+1;k<m.length;k++){
                //c=[5,6,0,3,2]
                //   0,1,2,3,4
                int c1=c.get(j);//j=0   , c1=5
                int c2=c.get(k);//k=1   ,c2=5
                if(c1==c2){
                    EVM+=2*m[j][k]-1; // point 8
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
        
        //part 4
        //1/ c=[1,2,3,4,5]   size=5
        //      0,1,2,3,4
        
        //c=[1,2,4,4,5]
        //   0,1,2,3,4
        
        // c=[1,2,3,4,5]
        
        //2. random index // 2
        //3. random no   // 4
        //4. index!=no   //
        //5. no<size of cluster  
        // c[index]=no
        
        
        int[] randomArr; // index , no
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
                    c.set(randomArr[0], temp);//undo the change
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
        int index,no;
        index=UI(1,c.size()); // random index
        do{
        no=UI(1,c.size());  // random number
        }while(c.get(index)==no);// index=no
        return new int[]{index,no};
    }
    
    // unique random number function
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
