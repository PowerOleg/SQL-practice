//        long now = System.currentTimeMillis();
//        Date sqlDate2 = Date.valueOf(LocalDate.of(1983, Month.JULY, 12));
//        System.out.println("SqlDate2: " + sqlDate2);

import com.jdbc.dao.Query1;
import com.jdbc.pojo.Department;
import com.jdbc.pojo.Employee;

import java.sql.Date;



public class Main {
    public static void main(String[] args) {
//        Date sqlDate1 = Date.valueOf("2001-01-01");
//        Date sqlDate2 = Date.valueOf("2011-01-01");
//        Date sqlDate3 = Date.valueOf("2021-01-01");
        Date sqlDate4 = Date.valueOf("2022-01-01");
//        Date sqlDate5 = Date.valueOf("2022-06-01");
//        Employee employee1 = new Employee(205, sqlDate1, "Danil", 30000);
//        Employee employee2 = new Employee(210, sqlDate2, "Oleg", 40000);
//        Employee employee3 = new Employee(299, sqlDate3, "Aleksandr", 50000);
//        Employee employee4 = new Employee(940, sqlDate4, "Vladimir", 60000);
//        Employee employee5 = new Employee(null, sqlDate5, "Alena", 60000);
//
//
//        Department department2 = new Department(210, "Strength", 2);
//        Department department3 = new Department(299, "Laboratory", 3);
//        Department department4 = new Department(940, "Leading", 4);
        Query1 query1 = new Query1();
        Employee selectedEmployee = query1.select(sqlDate4, 60000);
        System.out.println(selectedEmployee);
    }
}