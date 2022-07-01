import java.util.Objects;

public class Person {
    private String name;
    private String password;
    private int heightScore;
    public Person(String name,String password,int score){
        this.name=name;
        this.password=password;
        this.heightScore =score;
    }

    public Person(){

    }
    public Person(String str){
        String[] split=str.split(",");
        name=split[0];
        password=split[1];
        heightScore =Integer.parseInt(split[2]);
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, heightScore);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHeightScore() {
        return heightScore;
    }

    public void setHeightScore(int heightScore) {
        this.heightScore = heightScore;
    }

    @Override
    public String toString() {
        return name + "," + password + "," + heightScore+"\n";
    }

}
