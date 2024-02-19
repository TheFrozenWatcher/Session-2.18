package Ex6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ex6 {
    public static void main(String[] args) {
        // Thay đổi đường dẫn tới file văn bản của bạn
        String link = "C:\\Users\\HUNG\\IdeaProjects\\Module 2 JAVA\\Session 2.18\\src\\Ex6\\doc.txt";

        // Bước 1: Đọc nội dung từ tệp văn bản
        String fileContent = readFile(link);

        // Bước 2: Tính toán tần suất xuất hiện của từng từ
        Map<String, Integer> wordFrequencyMap = calculateFrequency(fileContent);

        // Bước 3: Xác định từ được sử dụng nhiều nhất
        findMostUsed(wordFrequencyMap);

    }

    private static String readFile(String fileLink) {
        StringBuilder noiDung = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileLink))) {
            String line;
            while ((line = br.readLine()) != null) {
                noiDung.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file văn bản: " + e.getMessage());
        }
        return noiDung.toString();
    }

    private static Map<String, Integer> calculateFrequency(String content) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = content.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Loại bỏ các ký tự không phải chữ cái
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequency;
    }

    private static void findMostUsed(Map<String, Integer> wordFrequency) {
        String mostUsed = null;
        int frequency = 0;

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > frequency) {
                mostUsed = entry.getKey();
                frequency = entry.getValue();
            }
        }

        System.out.println("Từ được sử dụng nhiều nhất: " + mostUsed);
        System.out.println("Tần suất xuất hiện: " + frequency);    }


}
