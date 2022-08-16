import java.util.Comparator;
// class sắp xếp nhân viên theo bảng lương giảm dần
public class SalarySortDesc implements Comparator<Staff> {
    public int compare(Staff s1, Staff s2)
    {
        double s1Salary = (s1 instanceof Employee)
                ? ((Employee) s1).calculateSalary()
                : ((Manager) s1).calculateSalary();
        double s2Salary = (s2 instanceof Employee)
                ? ((Employee) s2).calculateSalary()
                : ((Manager) s2).calculateSalary();
        if (s1Salary == s2Salary)
            return 0;
        else if (s1Salary> s2Salary)
            return -1;
        else
            return 1;
    }
}
