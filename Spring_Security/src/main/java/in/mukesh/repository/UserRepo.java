package in.mukesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mukesh.entity.Userss;

import java.util.List;


public interface UserRepo extends JpaRepository<Userss, Integer>{
	Userss findByUsername(String username);

}
