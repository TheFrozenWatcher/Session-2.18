package Ex8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productCode;
    private String productName;
    private String manufacturer;
    private double price;
    private String otherDescriptions;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(String otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    public Product(String productCode, String productName, String manufacturer, double price, String otherDescriptions) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.otherDescriptions = otherDescriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", otherDescriptions='" + otherDescriptions + '\'' +
                '}';
    }
}


public class Ex8 {
    private static final String FILE_NAME = "C:\\Users\\HUNG\\IdeaProjects\\Module 2 JAVA\\Session 2.18\\src\\Ex8\\product-data.txt";

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        loadProductsFromFile(products);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");

            System.out.print("Chọn một lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống

            switch (choice) {
                case 1:
                    addProduct(products, scanner);
                    break;
                case 2:
                    displayProducts(products);
                    break;
                case 3:
                    searchProduct(products, scanner);
                    break;
                case 4:
                    saveProductsToFile(products);
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);

        scanner.close();
    }
    private static void addProduct(List<Product> products, Scanner scanner) {
        System.out.println("Nhập thông tin sản phẩm:");
        System.out.print("Mã sản phẩm: ");
        String productCode = scanner.nextLine();
        System.out.print("Tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng trống
        System.out.print("Mô tả khác: ");
        String otherDescriptions = scanner.nextLine();

        Product newProduct = new Product(productCode, productName, manufacturer, price, otherDescriptions);
        products.add(newProduct);

        System.out.println("Đã thêm sản phẩm mới.");
    }

    private static void displayProducts(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void searchProduct(List<Product> products, Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần tìm kiếm: ");
        String searchCode = scanner.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.getProductCode().equalsIgnoreCase(searchCode)) {
                System.out.println("Sản phẩm được tìm thấy:");
                System.out.println(product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã '" + searchCode + "'.");
        }
    }

    private static void loadProductsFromFile(List<Product> products) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            products.addAll((List<Product>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            // Bỏ qua nếu có lỗi (có thể file không tồn tại hoặc là lần chạy đầu tiên)
        }
    }

    private static void saveProductsToFile(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
            System.out.println("Đã lưu thông tin sản phẩm vào file.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }
}

