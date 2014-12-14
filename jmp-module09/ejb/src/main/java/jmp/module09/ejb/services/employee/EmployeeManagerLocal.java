package jmp.module09.ejb.services.employee;

import javax.ejb.Local;
import java.util.List;

import jmp.module09.jpa.model.Employee;

@Local
public interface EmployeeManagerLocal {
	
    void createEmployee(Employee employee);
    
    void deleteEmployee(long employeeId);
    
    void updateEmployee(long employeeId, Employee employee);

    List<Employee> list();
    
    Employee getEmployee(long employeeId);
}
