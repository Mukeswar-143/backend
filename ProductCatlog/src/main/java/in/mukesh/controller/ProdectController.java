package in.mukesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.mukesh.entity.ProductEntity;
import in.mukesh.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProdectController {

    @Autowired
    private ProductService pService;

    @PostMapping("/entry")
    public String saveProduct(@RequestBody ProductEntity pEntity) {
        pService.saveProduct(pEntity);
        return "Data entered";
    }

    @GetMapping("/{pid}")
    public ResponseEntity<ProductEntity> getById(@PathVariable Long pid) {
        ProductEntity product = pService.getProductById(pid);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ProductEntity>> getAllProducts(
            @PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<ProductEntity> products = pService.getAllProducts(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
