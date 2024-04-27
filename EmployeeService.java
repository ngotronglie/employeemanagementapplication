package employeemanagementapplication;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ngotr
 */
public class EmployeeService {

    HashSet<Employee> empset = new HashSet<>();
    /**
     * => Dòng này tạo một HashSet mới để lưu trữ các đối tượng Employee.
     *
     * - Tốc độ truy cập nhanh: HashSet cung cấp thời gian truy cập tốt đối với
     * các phần tử, với độ phức tạp trung bình là O(1) cho các thao tác thêm,
     * xóa và kiểm tra có tồn tại.
     *
     * - Loại bỏ các phần tử trùng lặp: HashSet không chấp nhận các phần tử
     * trùng lặp. Điều này đảm bảo rằng mỗi phần tử trong HashSet là duy nhất.
     *
     * - Không theo thứ tự: HashSet không duy trì bất kỳ thứ tự cụ thể nào của
     * các phần tử. Nếu bạn cần duy trì thứ tự cụ thể của các phần tử, bạn có
     * thể sử dụng một cấu trúc dữ liệu khác như LinkedHashSet.
     *
     * - Không thread-safe: HashSet không được đồng bộ hóa (non-synchronized),
     * điều này có nghĩa là nó không an toàn khi sử dụng trong môi trường đa
     * luồng mà không có các biện pháp đồng bộ hóa bổ sung.
     *
     */

    Employee emp1 = new Employee(101, "Shital", 24, "Developer", "IT", 25000);
    Employee emp2 = new Employee(102, "Meena", 26, "Tester", "CO", 57000);
    Employee emp3 = new Employee(103, "Bob", 20, "DevOps Eng", "Admin", 5000);
    Employee emp4 = new Employee(104, "Max", 27, "System Eng", "CO", 70000);

    Scanner sc = new Scanner(System.in);
    boolean found = false;
    int id;
    String name;
    int age;
    String department;
    String desiganation;
    double salary;

    public EmployeeService() {

        empset.add(emp1);
        empset.add(emp2);
        empset.add(emp3);
        empset.add(emp4);

    }

    //view all employees
    public void viewAllEmps() {
        for (Employee emp : empset) {
            System.out.println(emp);
        }
    }
    //view emp based on there id

    public void viewEmp() {

        System.out.print("Enter id: ");
        id = sc.nextInt();
        for (Employee emp : empset) {
            if (emp.getId() == id) {
                System.out.println(emp);
                found = true;
            }

        }
        if (!found) {
            System.out.println("\t=> Employee with this id is not present");
        }
    }
    //update the employee

    public void updateEmployee() {
        System.out.print("Enter id: ");
        id = sc.nextInt();
        boolean found = false;
        for (Employee emp : empset) {
            if (emp.getId() == id) {
                System.out.println("Enter name: ");
                name = sc.next();
                System.out.println("Enter new Salary");
                salary = sc.nextDouble();
                emp.setName(name);
                emp.setSalary(salary);
                System.out.println("Updated Details of employee are: ");
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee is not present");
        } else {
            System.out.println("\t => Employee details updated successfully !!");
        }
    }
    //delete emp

    public void deleteEmp() {
        System.out.print("Enter id: ");
        id = sc.nextInt();
        boolean found = false;
        Employee empdelete = null;
        for (Employee emp : empset) {
            if (emp.getId() == id) {
                empdelete = emp;
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t => Employee is not present");
        } else {
            empset.remove(empdelete);
            System.out.println("\t=> Employee deleted successfully!!");
        }
    }
    //add emp

    public void addEmp() {
        Scanner sc = new Scanner(System.in);

        // Nhập id từ người dùng
        System.out.print("Enter id (int): ");
        int id = sc.nextInt();

        // Bỏ qua dòng trống sau khi nhập số nguyên trước đó
        sc.nextLine();

        // Nhập tên từ người dùng
        System.out.print("Enter name (string): ");
        String name = sc.nextLine();

        // Nhập tuổi từ người dùng
        System.out.print("Enter age (int): ");
        age = sc.nextInt();

        // Bỏ qua dòng trống sau khi nhập số nguyên trước đó
        sc.nextLine();

        // Nhập Designation từ người dùng
        System.out.print("Enter Designation (string): ");
        desiganation = sc.nextLine();

        // Nhập Department từ người dùng
        System.out.print("Enter Department (string): ");
        department = sc.nextLine();

        // Nhập lương từ người dùng
        System.out.print("Enter salary (double): ");
        salary = sc.nextDouble();

        // Tạo đối tượng Employee mới với các thông tin đã nhập
        Employee emp = new Employee(id, name, age, desiganation, department, salary);

        // Thêm đối tượng Employee mới vào HashSet empset
        empset.add(emp);

        // Hiển thị thông tin của Employee mới đã thêm và thông báo thành công
        System.out.println(emp);
        System.out.println("\t=> Employee added successfully!!");
    }

}
