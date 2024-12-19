package serialize;

import java.io.*;

public class TestSerialize {
    public static void main(String[] args) throws IOException {
        //初始化对象信息
        Person person = new Person();
        person.setName("JavaBuild");
        person.setAge(30);
        System.out.println(person.getName()+" "+person.getAge());

        //序列化过程
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));) {
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person.par1 = "序列化后静态字段";
        //反序列化过程
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));) {
            Person p = (Person) objectInputStream.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class Person implements Serializable{

    private static final long serialVersionUID = 87119227404331L;
    private String name;
    private int age;

    public static String par1 = "静态字段";
    transient String par2 = "临时字段";
    transient int high = 175;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", par1=" + par1 +
                ", high=" + high +
                ", par2='" + par2 + '\'' +
                '}';
    }
}
