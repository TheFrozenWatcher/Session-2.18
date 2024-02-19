package Ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        // Bước 1: Tạo file gốc và nhập văn bản
        String sourceFileName = "doc.txt";
        createSourceFile(sourceFileName);

        // Bước 2: Đọc nội dung từ file gốc
        String sourceContent = readFile(sourceFileName);

        // Bước 3 và 4: Đảo ngược thứ tự từ và chuyển thành string mới
        String reversedContent = reverseWordOrder(sourceContent);

        // Bước 5: Ghi ra file mới
        String targetFileName = "file_moi.txt";
        writeFile(targetFileName, reversedContent);
    }

    // Bước 1: Tạo file gốc và nhập văn bản
    private static void createSourceFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Đề bài: Viết chương trình đọc nội dung từ file text và tạo một bản sao của file đó với tên mới và các từ được đảo ngược thứ tự.");
            System.out.println("Đã tạo file gốc: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo file gốc: " + e.getMessage());
        }
    }

    // Bước 2: Đọc nội dung từ file
    private static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return content.toString();
    }

    // Bước 3 và 4: Đảo ngược thứ tự từ và chuyển thành string mới
    private static String reverseWordOrder(String content) {
        List<String> wordList = Arrays.asList(content.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // Bước 5: Ghi ra file mới
    private static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Đã tạo file mới: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file mới: " + e.getMessage());
        }
    }
}
