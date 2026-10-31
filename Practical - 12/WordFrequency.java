import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
    }

    void display(){
    System.out.println("ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("Password: " + password);
    System.out.println();
    }
}

public class WordFrequency{
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Yashvi", "pass123"),
            new Student(2, "Kanishk", "pass456"),
            new Student(3, "Rahul", "pass789")
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
            System.out.println("Objects saved successfully.\n");
        } catch (IOException e) {
             System.out.println("Error saving objects: " + e.getMessage());
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            Student[] loadedStudents = (Student[]) in.readObject();
            System.out.println("Objects loaded from file:\n");

            for (Student student : loadedStudents) {
                student.display();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading objects: " + e.getMessage());
        }
    }
}
