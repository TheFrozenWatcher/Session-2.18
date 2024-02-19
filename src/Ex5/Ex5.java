package Ex5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        String fileLink = "C:\\Users\\HUNG\\IdeaProjects\\Module 2 JAVA\\Session 2.18\\src\\Ex5\\countries.csv";
        List<Country> countries=readCSVFile(fileLink);
        for (int i=0;i<countries.size();i++){
            System.out.println("Country [id= "+countries.get(i).getId()+", code= "+countries.get(i).getCode()+", name= "+countries.get(i).getName()+"]");
        }
    }

    private static List<Country> readCSVFile(String fileLink) {
        List<Country> countries = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(fileLink))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String code = parts[1];
                String name = parts[2];
                Country newCountry = new Country(id,code, name);
                countries.add(newCountry);
            }

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file CSV: " + e.getMessage());

        }
        return countries;
    }
}

//Tạo class country
class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}