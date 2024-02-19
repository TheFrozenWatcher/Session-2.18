package Ex9;

import java.io.Serializable;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Quản lý sách =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Hiển thị danh sách sách");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự Enter còn lại trong buffer

            switch (choice) {
                case 1:
                    Book newBook = enterBookInfo(scanner);
                    bookManager.addBook(newBook);
                    break;

                case 2:
                    Book updatedBook = enterBookInfo(scanner);
                    bookManager.updateBook(updatedBook);
                    break;

                case 3:
                    System.out.print("Nhập tên sách cần xóa: ");
                    String bookTitleToDelete = scanner.nextLine();
                    bookManager.deleteBook(bookTitleToDelete);
                    break;

                case 4:
//                    bookManager.loadFromFile();
                    bookManager.displayAllBooks();
                    break;

                case 0:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    private static Book enterBookInfo(Scanner scanner) {
        System.out.print("Nhập tên sách: ");
        String title = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        String author = scanner.nextLine();

        System.out.print("Nhập nhà xuất bản: ");
        String publisher = scanner.nextLine();

        System.out.print("Nhập giá tiền: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        return new Book(title, author, publisher, price);
    }
}

