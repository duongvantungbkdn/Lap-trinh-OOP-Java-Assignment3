import java.util.*;

public class HumanResources {
    public static void main(String[] args) {
        // khởi tạo ArrayList lưu danh sách nhân viên
        ArrayList<Staff> staffsArray = new ArrayList<Staff>();

        // khởi tạo các bộ phận của công ty
        ArrayList<Department> departsArray = new ArrayList<Department>();
        addDepartment(new Department("MKT","Marketing"),departsArray);
        addDepartment(new Department("HC","Hành chính nhân sự"),departsArray);
        addDepartment(new Department("IT","Công nghệ thông tin"),departsArray);

        // kiểm tra giá trị menu người dùng nhập vào để chạy chương trình
        System.out.println("Mời bạn nhập vào các con số tương ứng để thao tác với chương trình.");
        int chosen;
        // dùng vòng lặp do while để chương trình tiếp tục chạy lại khi người dùng chưa chọn thoát
        do{
            chosen = menuDisplay();
            switch (chosen) {
                case 1:
                    displayStaff(staffsArray);
                    break;
                case 2:
                    displayDepartmet(departsArray);
                    break;
                case 3:
                    displayStaffOnDepartment(staffsArray, departsArray);
                    break;
                case 4:
                    addNewStaff(staffsArray,departsArray);
                    break;
                case 5:
                    searchStaff(staffsArray);
                    break;
                case 6:
                    displayStaff(staffsArray);
                    break;
                case 7:
                    sortSalaryIncrease(staffsArray);
                    break;
                case 8:
                    sortSalaryDescrease(staffsArray);
                    break;
                default:
                    System.out.println("Bạn đã chọn ngoài giá trị cho phép. Mời bạn chọn lại!");
                    break;
            }
        }while (chosen != 0);
    }

    // chương trình hiển thị menu lựa chọn thao tác
    public static int menuDisplay() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
        System.out.println("0. Thoát chương trình");
        System.out.print("Lựa chọn của bạn: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
//        if(number == 0) {System.exit(0);  }
        System.out.println();
        return number;
    }

    //hàm thêm 1 bộ phận mới vào công ty
    public static void addDepartment(Department d, ArrayList<Department> arr) {
        // validate ID department
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getIdDepartment() == d.getIdDepartment()) {
                System.out.println("ID department = " + d.getIdDepartment() + " đã tồn tại ");
                return;
            }
        }
        arr.add(d);
    }

    //hàm hiển thị các bộ phận trong công ty
    public static void displayDepartmet(ArrayList<Department> arr) {
        System.out.format("%-15s %-35s %-25s\n", "Mã bộ phận", "| Tên bộ phận", "| Số lượng nhân viên");
        for(Department department : arr) {
            System.out.println(department.toString());
        }
        System.out.println();
    }

    // hàm thêm nhân viên mới vào công ty
    public static void addNewStaff(ArrayList<Staff> staffsArr,
                                   ArrayList<Department> departsArr) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên là cấp quản lý");
        System.out.print("Bạn chọn: ");
        int number = sc.nextInt();

        String id;
        boolean idExist;
        do{
            idExist = false;
            System.out.print("Nhập mã nhân viên: ");
            id = sc.next();

            // validate mã nhân viên là duy nhất
            for(Staff staff : staffsArr) {
                if(staff.getId().equalsIgnoreCase(id)) {
                    idExist = true;
                    System.out.println("Mã nhân viên " + id + " đã tồn tại, mời bạn nhập lại");
                    break;
                }
            }
        } while (idExist);

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Nhập tên nhân viên: ");
        String staffName = sc2.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        int age = sc.nextInt();
        System.out.print("Nhập hệ số lương nhân viên: ");
        double salaryRate = sc.nextDouble();
        System.out.print("Nhập ngày vào làm của nhân viên: ");
        String startDate = sc.next();
        System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
        int vacationDates = sc.nextInt();

        // chọn bộ phận từ mảng danh sách bộ phận
        for(int i=0; i < departsArr.size(); i++) {
            System.out.println(i+1 + ". "
                    + departsArr.get(i).getIdDepartment()
                    + " - "
                    + departsArr.get(i).getNameDepartment());
        }
        System.out.print("Bạn chọn bộ phận: ");
        int departNum = sc.nextInt();

        // validate departNum nằm trong khoảng từ 1 đến departsArr.size()
        Department department;
        if(departNum >= 1 && departNum <= departsArr.size()) {
            department = departsArr.get(departNum-1);
        } else {
            System.out.print("Bạn đã chọn bộ phận ngoài giá trị cho phép. Bạn đã chọn " + number);
            return;
        }

        // chọn nhân viên (có giờ làm thêm) hay quản lí (có chức danh)
        if(number == 1) {
            System.out.print("Nhập số giờ làm thêm: ");
            int extraHours = sc.nextInt();
            Staff st = new Employee(id,staffName,age,salaryRate,startDate,department,vacationDates,extraHours);
            addOneStaff(st,staffsArr,departsArr);
        } else if(number == 2) {
            System.out.println("Chức danh: ");
            System.out.println("1. Business Leader");
            System.out.println("2. Project Leader");
            System.out.println("3. Technical Leader");
            System.out.print("Nhập chức danh: ");
            String position = "";
            int positionNum = sc.nextInt();
            if(positionNum == 1) {position = "Business Leader";}
            else if(positionNum == 2) {position = "Project Leader";}
            else if(positionNum == 3) {position = "Technical Leader";}
            Staff st = new Manager(id,staffName,age,salaryRate,startDate,department,vacationDates,position);
            addOneStaff(st,staffsArr,departsArr);
        } else {
            System.out.print("Bạn chỉ được chọn loại nhân viên 1 hoặc 2. Bạn đã chọn " + number);
            return;
        }
        System.out.println();
    }

    //hàm hiển thị tất cả nhân viên trong công ty
    public static void displayStaff(ArrayList<Staff> staffsArr) {
        displayHeaderTable();
        System.out.println("----------------------------------------------------------------------------------------"
                            + "-------------------------------------------------------------------------------------");
        for(Staff staff : staffsArr) {
            staff.displayInformation();
        }
        System.out.println();
    }

    //hàm hiển thị nhân viên theo từng bộ phận
    public static void displayStaffOnDepartment(ArrayList<Staff> staffsArr, ArrayList<Department> departsArr) {
        for (Department depart : departsArr) {
            System.out.println(depart.getNameDepartment());
            System.out.println("-------------------------------------------");
            displayHeaderTable();

            for(Staff staff : staffsArr) {
                if(staff.getDepartment().getIdDepartment() == depart.getIdDepartment()) {
                    staff.displayInformation();
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // hàm tìm nhân viên theo tên hoặc id
    public static void searchStaff(ArrayList<Staff> staffsArr) {
        System.out.println("1. Tìm nhân viên bằng tên.");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên");
        System.out.print("Bạn chọn: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num == 1) {
            System.out.print("Nhập tên nhân viên cần tìm: ");
            String name = sc.next();
            displayHeaderTable();
            int count = 0;
            for(Staff staff : staffsArr) {
                if(staff.getName().contains(name)) {
                    staff.displayInformation();
                    count++;
                }
            }

            // Nếu không tìm thấy nhân viên nào thỏa mãn thì hiện thông báo cho người dùng
            if(count == 0) {
                System.out.println("Không tìm thấy nhân viên nào có tên phù hợp.");
            }

        } else if(num == 2) {
            System.out.print("Nhập mã nhân viên cần tìm: ");
            String id = sc.next();
            displayHeaderTable();
            int count = 0;
            for(Staff staff : staffsArr) {
                if(staff.getId().contains(id)) {
                    staff.displayInformation();
                    count++;
                }
            }

            // Nếu không tìm thấy nhân viên nào thỏa mãn thì hiện thông báo cho người dùng
            if(count == 0) {
                System.out.println("Không tìm thấy nhân viên nào có mã nhân viên phù hợp.");
            }
        } else {
            System.out.print("Bạn chỉ được chọn tìm nhân viên 1 hoặc 2. Bạn đã chọn " + num);
            return;
        }
        System.out.println();
    }

    public static void displayHeaderTable() {
        System.out.format(
                "%-20s %-25s %-10s %-15s %-20s %-25s %-15s %-25s %-10s\n",
                "Mã nhân viên",
                "| Tên nhân viên",
                "| Tuổi",
                "| Hệ số lương",
                "| Ngày vào làm",
                "| Bộ phận",
                "| Số ngày phép",
                "| Số giờ làm thêm / Chức vụ",
                "| Lương"
        );
    }

    // hiển thị nhân viên theo bảng lương tăng dần
    public static void sortSalaryIncrease(ArrayList<Staff> staffsArr) {
        Collections.sort(staffsArr,new SalarySortInc());
        displayStaff(staffsArr);
    }

    //Hiển thị nhân viên theo bảng lương giảm dần
    public static void sortSalaryDescrease(ArrayList<Staff> staffsArr) {
        Collections.sort(staffsArr,new SalarySortDesc());
        displayStaff(staffsArr);
    }

    // hàm thêm một nhân viên
    public static void addOneStaff(Staff st, ArrayList<Staff> staffsArr, ArrayList<Department> departsArr) {
        staffsArr.add(st);
        // tăng số lượng nhân viên trong bộ phận lên
        for(Department department : departsArr) {
            if(department.getIdDepartment() == st.getDepartment().getIdDepartment()) {
                department.increaseStaffCount();
            }
        }
    }
}
