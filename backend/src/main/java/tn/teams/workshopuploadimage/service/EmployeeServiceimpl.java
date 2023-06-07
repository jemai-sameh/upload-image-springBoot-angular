package tn.teams.workshopuploadimage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import tn.teams.workshopuploadimage.entite.Employee;
import tn.teams.workshopuploadimage.repository.EmployeeRepository;
@Service

public class EmployeeServiceimpl implements EmployeeService{
	@Autowired
	private   EmployeeRepository rmployeeRepository;
	@Autowired
	private  ImageStorage imageStorage;
	@Override
	public void deleteEmployee(Long id) {
		rmployeeRepository.deleteById(id);
	}
	@Override
	public List<Employee> listeallEmployee() {
		// TODO Auto-generated method stub
		return rmployeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findByIdEmployee(Long id) {
		// TODO Auto-generated method stub
		return rmployeeRepository.findById(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return rmployeeRepository.save(employee);
	}
	public ResponseEntity<Employee> findbyId(Long id) {
        if (id == null) {
          //  log.error("student ID is null");
            return null;
        }
        return ResponseEntity.ok(rmployeeRepository.findById(id).get());
	}
	@Override
	public Employee uploadImageEmployee(Long empId, MultipartFile image) {
		ResponseEntity<Employee> employeeResponse = this.findbyId(empId);
        String imageName=imageStorage.store(image);
        String fileImageDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/employee/downloadEmployeeImage/").path(imageName).toUriString();
        Employee empl = employeeResponse.getBody();
        if (empl!=null)
        	empl.setImage(fileImageDownloadUrl);
        return this.saveEmployee(empl);
	}

}
