package Ex7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Ex7 {
    public static void main(String[] args) {
        // Bước 2: Sử dụng ObjectInputStream để đọc từ tệp
        String link = "C:\\Users\\HUNG\\IdeaProjects\\Module 2 JAVA\\Session 2.18\\src\\Ex7\\students.dat";
        List<Student> students = readBinaryFile(link);

        // Bước 3: Hiển thị danh sách lên màn hình
        displayStudentList(students);

        // Bước 4: Đóng tệp và kết thúc chương trình
    }

    private static List<Student> readBinaryFile(String fileLink) {
        List<Student> students = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileLink))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Đã đọc danh sách sinh viên từ tệp nhị phân.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc từ tệp nhị phân: " + e.getMessage());
        }

        return students;
    }

    private static void displayStudentList(List<Student> list) {
        System.out.println("Danh sách sinh viên:");
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

