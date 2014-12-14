package jmp.module09.ejb.services.employee;

import javax.ejb.Remote;
import java.util.List;

import jmp.module09.jpa.model.Employee;

@Remote
public interface EmployeeManager {

	void createEmployee(Employee employee);

	void deleteEmployee(long employeeId);

	void updateEmployee(long employeeId, Employee employee);

	List<Employee> list();

	Employee getEmployee(long employeeId);
}

