package in.mukesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.mukesh.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
	
}
