package tn.teams.workshopuploadimage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tn.teams.workshopuploadimage.entite.Employee;


public interface EmployeeService {
	void deleteEmployee(Long id);
	List<Employee> listeallEmployee ();
	Optional<Employee> findByIdEmployee(Long id);
	Employee saveEmployee(Employee employee);
	Employee uploadImageEmployee(Long empId, MultipartFile image);
}
