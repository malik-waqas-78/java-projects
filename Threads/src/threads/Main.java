
package threads;


public class Main
{
	public static void main(String[] args) {
            //TempClass parent=new TempClass();
            System.out.println(Double.parseDouble("4"));
	}
	
    public static Runnable run=new Runnable(){
        @Override
        public void run(){
            while(true){
                System.out.println("Process "+Thread.currentThread().getId());
		    try{
		        Thread.sleep(5000);
		    }catch(InterruptedException ex){
		        
		    }
            }
        }
    };
}
