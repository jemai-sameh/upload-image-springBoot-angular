package tn.teams.workshopuploadimage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.teams.workshopuploadimage.entite.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
