// class nhân viên bình thường kế thừa từ class nhân viên nói chung
public class Employee extends Staff implements ICalculator{
    // nhân viên bình thường có thêm thuộc tính số giờ làm thêm
    private int extraHours;

    // phương thức khởi tạo một nhân viên bình thường
    public Employee(
            String id,
            String name,
            int age,
            double salaryRate,
            String startDate,
            Department department,
            int vacationDates,
            int extraHours
    ) {
        super(id, name, age, salaryRate, startDate, department, vacationDates);
        this.extraHours = extraHours;
    }

    public int getExtraHours() {
        return extraHours;
    }

    //phương thức hiển thị thông tin của 1 nhân viên bình thường
    @Override // from Staff
    public void displayInformation() {
        System.out.format(
                "%-15s %-25s %-10s %-15s %-20s %-25s %-15s %-25s %-10s\n",
                this.getId(),
                "| " + this.getName(),
                "| " + this.getAge(),
                "| " + this.getSalaryRate(),
                "| " + this.getStartDate(),
                "| " + this.getDepartment().getNameDepartment(),
                "| " + this.getVacationDates(),
                "| " + this.getExtraHours(),
                "| " + this.calculateSalary()
        );
    }

    //phương thức tính lương của 1 nhân viên bình thường
    @Override // from ICalculator
    public double calculateSalary() {
        double salary = 0.0;
        salary = super.getSalaryRate() * 3000000 + this.extraHours * 200000;
        return salary;
    }
}
