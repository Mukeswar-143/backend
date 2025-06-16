package in.mukesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.mukesh.entity.ProductEntity;
import in.mukesh.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://productcatalog-beta.vercel.app")
public class ProdectController {

    @Autowired
   
    private ProductService pService;

    // @PostMapping("/addProduct")
    // public String saveProduct(@RequestBody ProductEntity pEntity) {
    // pService.saveProduct(pEntity);
    // return "Data Entered";
    // }
    @PostMapping("/entry")
    public ResponseEntity<String> saveProduct(@RequestBody ProductEntity pEntity) {
        if (pService.getByPid(pEntity.getPid()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product with same pid already exists");
        } else {
            pService.saveProduct(pEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
        }
    }
    // @GetMapping("/productId/{id}")
    // public ProductEntity getBypId(@PathVariable Long id) {
    // return pService.getByPid(id);
    // }

     @GetMapping("/all")
     public List<ProductEntity> getAll() {
     return pService.getAll();
     }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductEntity> getByPid(@PathVariable Long id) {
        ProductEntity product = pService.getByPid(id);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getProductByPagination")
    public ResponseEntity<Page<ProductEntity>> getAllProducts(
            @PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<ProductEntity> products = pService.getAllProducts(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductById/{pid}")
    public ResponseEntity<String> deleteProductByPid(@PathVariable Long pid) {
        boolean deleted = pService.deleteProductByPid(pid);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully with pid : " + pid);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Index");
        }
    }
}
