package az.developia.spring_project_14aprel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_project_14aprel.entity.Computer;

public interface ComputerRepo extends JpaRepository<Computer, Integer> {

}