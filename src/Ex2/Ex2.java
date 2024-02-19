package Ex2;

import java.io.*;

public class Ex2 {
    public static void main(String[] args) {
        // Nhập file cần thao tác
        String sourceFileName = getInputString("Nhập đường dẫn file nguồn: ");
        String targetFileName = getInputString("Nhập đường dẫn file mục tiêu: ");

        // Kiểm tra file nguồn
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.out.println("Lỗi: Chưa có file nguồn.");
            return;
        }

        // Kiểm tra file mục tiêu đã tồn tại chưa
        File targetFile = new File(targetFileName);
        if (!targetFile.exists()) {
            System.out.println("Lỗi: File nhận dữ liệu chưa tồn tại, hệ thống sẽ tạo 1 file mới.");
            try {
                if (targetFile.createNewFile()) {
                    System.out.println("Tạo file thành công.");
                } else {
                    System.out.println("Không tạo được file mới.");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi tạo file: " + e.getMessage());
                return;
            }
        }

        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Sao chép thành công. Số byte trong tệp là: " + targetFile.length());

        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép: " + e.getMessage());
        }
    }

    // Nhập dữ liệu người dùng
    private static String getInputString(String prompt) {
        System.out.print(prompt);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Lỗi nhập liệu: " + e.getMessage());
        }
    }
}
