// class nhân viên quản lí kế thừa từ class nhân viên nói chung
public class Manager extends Staff implements ICalculator{
    // nhân viên quản lí có thêm thuộc tính chức vụ
    private String position;

    // hàm khởi tạo
    public Manager(
            String id,
            String name,
            int age,
            double salaryRate,
            String startDate,
            Department department,
            int vacationDates,
            String position
    ) {
        super(id, name, age, salaryRate, startDate, department, vacationDates);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //phương thức hiển thị thông tin của 1 nhân viên quản lí
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
                "| " + this.getPosition(),
                "| " + this.calculateSalary()
        );
    }

    //phương thức tính lương của 1 nhân viên quản lí
    @Override // from ICalculator
    public double calculateSalary() {
        int duty = 0;
        double salary = 0.0;
        if(this.position == "Business Leader") {duty = 8000000;}
        else if(this.position == "Project Leader") {duty = 5000000;}
        else if(this.position == "Technical Leader") {duty = 6000000;}
        salary = super.getSalaryRate() * 5000000 + duty;
        return salary;
    }
}
