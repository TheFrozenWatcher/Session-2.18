package Ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {
    public static void main(String[] args) {
        String fileName="C:\\Users\\HUNG\\IdeaProjects\\Module 2 JAVA\\Session 2.18\\src\\Ex3\\doc.txt";
        String fileContent=readFile(fileName);
        String longestWord=findLongestWord(fileContent);
        if (longestWord!=null){
            System.out.println("Từ dài nhất là "+ longestWord);
        } else {
            System.out.println("Không có từ nào hợp lệ");
        }
    }
    public static String readFile (String fileName){
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
    public static String findLongestWord(String string) {
        if (!string.isEmpty() && string != null) {
            String[] stringArr = string.split("\\s+");
            String longestWord=stringArr[0];
            for (int i=1;i<stringArr.length;i++){
                if (stringArr[i].length()>longestWord.length()){
                    longestWord=stringArr[i];
                }
            }
            return longestWord;
        } else {
            return null;
        }
    }
}
