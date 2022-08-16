
// class định cấu hình cho các thuộc tính và phương thức của 1 bộ phận trong công ty
public class Department {
    // các thuộc tính: Mã bộ phận, tên bộ phận, số lượng nhân viên trong bộ phận
    private String idDepartment;
    private String nameDepartment;
    private int staffCount = 0;

    public Department() {}

    // hàm khởi tạo một bộ phận
    public Department(String idDepartment, String nameDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    // các phương thức setter và getter
    public void increaseStaffCount() {
        this.staffCount++;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public int getStaffCount() {
        return staffCount;
    }

    //phương thức toString để trả về chuỗi string chứa thông tin về bộ phận
    public String toString() {
        String string = String.format(
                "%-15s %-35s %-25s",
                this.getIdDepartment(),
                "| " + this.getNameDepartment(),
                "| " + this.getStaffCount()
        );
        return string;
    }
}
