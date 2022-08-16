// superclass trừu tượng định cấu hình cho các thuộc tính và phương thức của 1 nhân viên nói chung
public abstract class Staff {
    // các thuộc tính chung: id, tên , tuổi, hệ số lương, ngày bắt đầu làm việc, bộ phận, số ngày nghỉ phép
    private String id;
    private String name;
    private int age;
    private double salaryRate;
    private String startDate;
    private Department department;
    private int vacationDates;

    // hàm khởi tạo
    public Staff(
            String id,
            String name,
            int age,
            double salaryRate,
            String startDate,
            Department department,
            int vacationDates
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryRate = salaryRate;
        this.startDate = startDate;
        this.department = department;
        this.vacationDates = vacationDates;
    }

    // các phương thức getter và setter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public Department getDepartment() {
        return department;
    }

    public int getVacationDates() {
        return vacationDates;
    }

    // phương thức hiển thị thông tin nhân viên
    abstract void displayInformation();
}
