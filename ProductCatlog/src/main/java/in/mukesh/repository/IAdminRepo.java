package in.mukesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mukesh.entity.AdminEntity;

import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<AdminEntity, Integer> {    
	
	  AdminEntity findByEmailAndPassword(String email, String password);
}


