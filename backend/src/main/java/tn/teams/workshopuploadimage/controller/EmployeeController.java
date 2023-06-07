package tn.teams.workshopuploadimage.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import tn.teams.workshopuploadimage.entite.Employee;
import tn.teams.workshopuploadimage.service.EmployeeService;
import tn.teams.workshopuploadimage.service.ImageStorage;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService EmployeeService;
	@Autowired
	private  ImageStorage imageStorage;
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		EmployeeService.deleteEmployee(id);
	}
	@GetMapping("/lister")
	public List<Employee> listeallEmployee() {
		return EmployeeService.listeallEmployee();
	}
	@GetMapping("/listerbyid/{id}")
	public Optional<Employee> findByIdEmployee(@PathVariable Long id) {
		return EmployeeService.findByIdEmployee(id);
	}
@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return EmployeeService.saveEmployee(employee);
	}
@PostMapping("/uploadEmployeeImage/{empId}")
	public Employee uploadImageEmployee(@PathVariable Long empId, MultipartFile image) {
		return EmployeeService.uploadImageEmployee(empId, image);
	}

	
	@GetMapping("/downloadEmployeeImage/{imageName}")
	public ResponseEntity<Resource> downloadTeacherImage(@PathVariable String imageName, HttpServletRequest request) {
		return this.imageStorage.downloadUserImage(imageName, request);
	}
	
	

}
