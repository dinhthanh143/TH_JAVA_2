import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(100);
        int choice;

        do {
            System.out.println("===== QUAN LY SINH VIEN =====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi tat ca");
            System.out.println("3. Tim kiem");
            System.out.println("4. Cap nhat");
            System.out.println("5. Xoa");
            System.out.println("6. Tinh diem TB");
            System.out.println("7. Sap xep");
            System.out.println("8. Thong ke");
            System.out.println("9. Thoat");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Ma SV: ");
                    String ma = sc.nextLine();
                    System.out.print("Ho ten: ");
                    String ten = sc.nextLine();
                    System.out.print("Tuoi: ");
                    int tuoi = Integer.parseInt(sc.nextLine());
                    System.out.print("Gioi tinh: ");
                    String gt = sc.nextLine();
                    System.out.print("Toan: ");
                    double t = Double.parseDouble(sc.nextLine());
                    System.out.print("Ly: ");
                    double l = Double.parseDouble(sc.nextLine());
                    System.out.print("Hoa: ");
                    double h = Double.parseDouble(sc.nextLine());
                    if (manager.them(new Student(ma, ten, tuoi, gt, t, l, h)))
                        System.out.println("Them thanh cong");
                    else
                        System.out.println("Them that bai");
                    break;

                case 2:
                    manager.hienThiTatCa();
                    break;

                case 3:
                    System.out.print("Nhap ma hoac ten: ");
                    String key = sc.nextLine();
                    Student s = manager.timTheoMa(key);
                    if (s != null) s.hienThi();
                    else manager.timTheoTen(key);
                    break;

                case 4:
                    System.out.print("Nhap ma: ");
                    String m = sc.nextLine();
                    Student st = manager.timTheoMa(m);
                    if (st != null) {
                        System.out.print("Ten moi: ");
                        st.setHoTen(sc.nextLine());
                        System.out.print("Tuoi moi: ");
                        st.setTuoi(Integer.parseInt(sc.nextLine()));
                        System.out.print("Toan: ");
                        st.setDiemToan(Double.parseDouble(sc.nextLine()));
                        System.out.print("Ly: ");
                        st.setDiemLy(Double.parseDouble(sc.nextLine()));
                        System.out.print("Hoa: ");
                        st.setDiemHoa(Double.parseDouble(sc.nextLine()));
                        System.out.println("Cap nhat thanh cong");
                    } else System.out.println("Khong tim thay");
                    break;

                case 5:
                    System.out.print("Nhap ma: ");
                    if (manager.xoa(sc.nextLine()))
                        System.out.println("Da xoa");
                    else
                        System.out.println("Khong tim thay");
                    break;

                case 6:
                    System.out.print("Nhap ma: ");
                    Student sv = manager.timTheoMa(sc.nextLine());
                    if (sv != null) sv.hienThi();
                    else System.out.println("Khong tim thay");
                    break;

                case 7:
                    System.out.println("1. Theo DTB giam");
                    System.out.println("2. Theo ten A-Z");
                    int opt = Integer.parseInt(sc.nextLine());
                    if (opt == 1) manager.sapXepTheoDTB();
                    else manager.sapXepTheoTen();
                    break;

                case 8:
                    manager.thongKe();
                    break;
            }
        } while (choice != 9);
    }
}
