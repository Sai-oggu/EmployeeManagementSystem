
public class Employee {
    String name, fname, dob, address, phone, email, education, designation, aadhar;
    int salary;
    String empId;

    public Employee(String name, String fname, String dob, String address, String phone, String email,
                    String education, String designation, String aadhar, int salary, String empId) {
        this.name = name;
        this.fname = fname;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.designation = designation;
        this.aadhar = aadhar;
        this.salary = salary;
        this.empId = empId;
    }
}
