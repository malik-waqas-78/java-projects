
package threads;


public class TempClass {
    Process p1=null;
           Process p2=null;
           Process p3=null;
           Process p4=null;
    public TempClass(){
        
        while(true){
            try{
                System.out.println(ProcessHandle.current().pid());
                String path = TempClass.class.getProtectionDomain().getCodeSource().getLocation().getPath();
           
                   
            
                 try{
                     if(p1==null||!p1.isAlive()){
                        p1 = new ProcessBuilder(path).start();
                       
                     }
                     if(p2==null||!p2.isAlive()){
                          p2 = new ProcessBuilder(path).start();
                     }
                    
//                    p3 = new ProcessBuilder(path).start();
//                    p4 = new ProcessBuilder(path).start();
                    p1.wait();
                    p2.wait();
//                    p3.wait();
//                    p4.wait();
                    
                    
                 }catch(Exception e){
                 }
           
                Thread.sleep(5000);
            }catch(Exception e){
                
            }
        }
        
    }
    
}
