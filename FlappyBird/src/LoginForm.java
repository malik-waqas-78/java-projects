import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class LoginForm extends javax.swing.JFrame {

    private javax.swing.JButton btn_signUp;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel tv_name;

    private javax.swing.JLabel tv_msg;
    private javax.swing.JLabel tv_password;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField et_name;
    private javax.swing.JTextField et_password;

    static ArrayList<Person> persons=new ArrayList<>();
    static int loggedIn=-1;

    public LoginForm() {
        initComponents();
        loadPersonsFromCredentialsFile();
    }




    private void initComponents() {

        panel = new javax.swing.JPanel();
        tv_name = new javax.swing.JLabel();
        tv_password = new javax.swing.JLabel();
        tv_msg=new javax.swing.JLabel();
        et_name = new javax.swing.JTextField();
        et_password = new javax.swing.JTextField();
        btn_signUp = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tv_name.setText("Name  :");

        tv_password.setText("Password :");

        tv_msg.setFont(new Font(Font.SERIF,Font.ITALIC,15));
        btn_signUp.setText("SignUp");

        btn_login.setText("Log in");

        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnLoginClicked();
            }
        });
        btn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpClicked();
            }
        });





        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tv_msg)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btn_login)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_signUp))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(tv_password)
                                                                .addComponent(tv_name))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(et_name)
                                                                .addComponent(et_password, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tv_name)
                                        .addComponent(et_name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tv_password)
                                        .addComponent(et_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_login)
                                        .addComponent(btn_signUp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                .addComponent(tv_msg)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        this.setTitle("Login Form");
    }

    WindowListener listener = new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
            Frame frame = (Frame) evt.getSource();
            if(!frame.getTitle().equals("Login Form")){
                LoginForm.this.setVisible(true);
                saveAllDetailsToFile();
            }
        }
    };

    private void saveAllDetailsToFile() {
        String str="";
        for(int i=0;i<persons.size();i++){
            str+=persons.get(i).toString();
        }
        try{
            FileWriter myWriter = new FileWriter("images/credentials.txt");
            myWriter.write(str);
            myWriter.close();
        }catch (Exception ex){

        }
    }

    private void btnSignUpClicked() {
        Person person=new Person();
        person.setName(et_name.getText().trim());
        person.setPassword(et_password.getText().trim());
        loggedIn=isUserAvailable(person);

        if(loggedIn==-1&&person.getName().length()>0&&person.getPassword().length()>0){
            person.setHeightScore(0);
            persons.add(person);
            writeToFile(person);
            tv_msg.setText("you have SignedUP successfully.Now you can Login.");
        }else{
            tv_msg.setText("User Already Exists");
        }
    }

    private void writeToFile(Person person) {
        try{
            FileWriter myWriter = new FileWriter("images/credentials.txt");
            myWriter.append(person.toString());
            myWriter.close();
        }catch (Exception e){

        }
    }

    private void btnLoginClicked() {

    if(persons.size()>0){
        Person person=new Person();
        person.setName(et_name.getText().trim());
        person.setPassword(et_password.getText().trim());
        loggedIn=isUserAvailable(person);

        if(loggedIn!=-1&&person.getName().length()>0&&person.getPassword().length()>0){
            this.setVisible(false);
            GameEngine gameEngine =new GameEngine();
            JFrame gameFrame=new JFrame();
            gameFrame.add(gameEngine);
            gameFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            gameFrame.setSize(GameEngine.WIDTH,GameEngine.HEIGHT);
            gameFrame.setVisible(true);
            gameFrame.addWindowListener(listener);
        }else{
            tv_msg.setText("Name or password is wrong.");
        }

    }else{
        tv_msg.setText("No user available. Please signUP.");
    }

    }

    private int isUserAvailable(Person person) {
        int i=0;
        if(persons.isEmpty()){
            return -1;
        }
        while (i<persons.size()){
            if(persons.get(i).equals(person)){
                return  i;
            }
            i++;
        }
        return -1;
    }

    private void loadPersonsFromCredentialsFile() {
       try{
           File file=new File("images/credentials.txt");
           FileReader  reader=new FileReader(file);
           BufferedReader bufferedReader=new BufferedReader(reader);
           String line;
           while ((line=bufferedReader.readLine())!=null){
                if(line.length()>0){
                    Person person=new Person(line);
                    persons.add(person);
                }
           }
           bufferedReader.close();
           reader.close();
       }catch (Exception e){

       }
    }


    public static void main(String args[]) {




        new LoginForm().setVisible(true);

    }

    public static  Person getLoggedInPerson(){
        if(loggedIn!=-1){
            return persons.get(loggedIn);
        }
        return null;
    }


}
