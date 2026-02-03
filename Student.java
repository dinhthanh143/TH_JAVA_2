import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double score;

    public Student() {
    }

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score >= 8.0) {
            return "Gioi";
        } else if (score >= 6.5) {
            return "Kha";
        } else {
            return "Trung Binh";
        }
    }

    public String toString() {
        return "Ma: " + id + ", Ten: " + name + ", Diem: " + score + ", Hoc luc: " + getRank();
    }
}

public class Main {
    static Student[] students = new Student[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUAN LY DIEM SINH VIEN =====");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo Hoc luc");
            System.out.println("4. Sap xep theo hoc luc giam dan");
            System.out.println("5. Thoat");
            System.out.println("==================================");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    nhapDanhSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timKiemTheoHocLuc();
                    break;
                case 4:
                    sapXepGiamDan();
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 5);
    }

    static void nhapDanhSach() {
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin sinh vien thu " + (i + 1) + ":");

            String id;
            while (true) {
                System.out.print("Nhap ma sinh vien (VD: SV001): ");
                id = sc.nextLine();
                if (id.startsWith("SV") && id.length() == 5) {
                    try {
                        Integer.parseInt(id.substring(2));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ma sinh vien khong hop le! Phai co dang SVxxx (x la so)");
                    }
                } else {
                    System.out.println("Ma sinh vien khong hop le! Phai co dang SVxxx");
                }
            }

            System.out.print("Nhap ten sinh vien: ");
            String name = sc.nextLine();

            System.out.print("Nhap diem trung binh: ");
            double score = sc.nextDouble();
            sc.nextLine();

            students[count] = new Student(id, name, score);
            count++;
        }
        System.out.println("Nhap thanh cong " + n + " sinh vien!");
    }

    static void hienThiDanhSach() {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("\n===== DANH SACH SINH VIEN =====");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + students[i].toString());
        }
    }

    static void timKiemTheoHocLuc() {
        System.out.print("Nhap hoc luc can tim (Gioi/Kha/Trung Binh): ");
        String rank = sc.nextLine();

        boolean found = false;
        System.out.println("\n===== KET QUA TIM KIEM =====");
        for (int i = 0; i < count; i++) {
            if (students[i].getRank().equals(rank)) {
                System.out.println(students[i].toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien co hoc luc: " + rank);
        }
    }

    static void sapXepGiamDan() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Sap xep thanh cong!");
        hienThiDanhSach();
    }
}
