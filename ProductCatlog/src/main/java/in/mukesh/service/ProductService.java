package in.mukesh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.mukesh.entity.ProductEntity;
import in.mukesh.repository.IProductRepo;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private IProductRepo pRepo;

	public void saveProduct(ProductEntity productEntity) {
		pRepo.save(productEntity);
	}

	public ProductEntity deleteProduct(Long pid) {
		return pRepo.deleteByPid(pid);
	}

	public ProductEntity getByPid(Long pid) {
		return pRepo.findByPid(pid);
	}

	public List<ProductEntity> getAll() {
		return pRepo.findAll();
	}

	public Page<ProductEntity> getAllProducts(Pageable pageable) {

		return pRepo.findAll(pageable);
	}

	@Transactional
	public boolean deleteProductByPid(Long pid) {
		ProductEntity product = pRepo.findByPid(pid);
		if (product != null) {
			pRepo.delete(product);
			return true;
		}
		return false;
	}
}
