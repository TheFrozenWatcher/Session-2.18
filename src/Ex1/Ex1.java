package Ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
    public static String readFile(String fileName){
        StringBuilder content = new StringBuilder();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return content.toString();
    }

    public static int countWord(String string) {
        if (!string.isEmpty() && string != null) {
            String[] stringArr = string.split("\\s+");
            return stringArr.length;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName="C:\\Users\\HUNG\\IdeaProjects\\Module 2 JAVA\\Session 2.18\\src\\Ex1\\Ex1.java";
        String fileContent=readFile(fileName);
        int wordCount=countWord(fileContent);
        System.out.println(wordCount);
    }
}
