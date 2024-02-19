package Ex7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteBinaryFile {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        List<Student> studentList = setStudentList();

        // Bước 2: Sử dụng ObjectOutputStream để ghi vào tệp
        String fileLink = "danh_sach_sinh_vien.dat";
        writeBinaryFile(studentList, fileLink);

        System.out.println("Đã tạo và ghi danh sách sinh viên vào tệp nhị phân.");
    }

    private static List<Student> setStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", 20));
        studentList.add(new Student("Alice", 22));
        studentList.add(new Student("Bob", 21));
        return studentList;
    }

    private static void writeBinaryFile(List<Student> studentList, String fileLink) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileLink))) {
            oos.writeObject(studentList);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào tệp nhị phân: " + e.getMessage());
        }
    }
}
