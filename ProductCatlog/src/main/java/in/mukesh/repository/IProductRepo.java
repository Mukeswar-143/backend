package in.mukesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.mukesh.entity.ProductEntity;

@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, Long> {

	public ProductEntity findByPid(Long pid);

	public ProductEntity deleteByPid(Long pid);

	public boolean existsByPid(Long pid);
}
