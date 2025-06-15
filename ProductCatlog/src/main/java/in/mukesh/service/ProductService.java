package in.mukesh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.mukesh.entity.ProductEntity;
import in.mukesh.repository.IProductRepo;

@Service
public class ProductService {

	@Autowired
	private IProductRepo pRepo;
	
	public String saveProduct(ProductEntity productEntity) {
		pRepo.save(productEntity);
		return "success";
	}
	
	public ProductEntity getProductById(Long id) {
		return pRepo.findByPid(id);
		
	}
	
	  public Page<ProductEntity> getAllProducts(Pageable pageable) {
		  
	        return pRepo.findAll(pageable);
	    }
}
