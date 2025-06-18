package in.mukesh.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mukesh.entity.ProductEntity;
import org.springframework.stereotype.Repository;



@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, Long> {

	public ProductEntity findByPid(Long pid);

	public ProductEntity deleteByPid(Long pid);

	public boolean existsByPid(Long pid);

	Page<ProductEntity> findByCategory(String category, Pageable pageable);
}
