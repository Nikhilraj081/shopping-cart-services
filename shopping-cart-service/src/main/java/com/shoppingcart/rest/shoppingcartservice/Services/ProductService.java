package com.shoppingcart.rest.shoppingcartservice.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingcart.rest.shoppingcartservice.Dao.ProductImageRepository;
import com.shoppingcart.rest.shoppingcartservice.Dao.ProductRepository;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ResourceNotFoundException;
import com.shoppingcart.rest.shoppingcartservice.Model.Product;
import com.shoppingcart.rest.shoppingcartservice.Model.ProductImage;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    SellerService sellerService;

    @Value("${image.path}")
    private String path;

    public List<Product> getAllProduct() throws ResourceNotFoundException
    {
        List<Product> product = productRepository.findAll();
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("There is no any product");
    }

    public Product getProductById(int id) throws ResourceNotFoundException
    {
        Product product = productRepository.findById(id);
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("product not found with id: "+ id);
    }

    public List<Product> getProductByCategory(String category) throws ResourceNotFoundException
    {
        List<Product> product = productRepository.findByProductCategory(category);
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("product not found with category: "+category);
    }

    public List<Product> getProductBySubCategory(String subCategory) throws ResourceNotFoundException
    {
        List<Product> product = productRepository.findByProductSubCategory(subCategory);
        if(product != null)
        {
            return product;
        }

        throw new ResourceNotFoundException("product not found with subcategory: "+subCategory);
    }

    public Product setProduct(int sellerId, Product product, MultipartFile[] image) throws IOException, ResourceNotFoundException
    {
        product.setSpecialPrice(product.getPrice() - product.getDiscount());
        product.setSeller(sellerService.getSellerById(sellerId));
        Product newProduct = null;
        
        //to save image in folder and database
        for (MultipartFile multipartFile : image)
        {

            //get file name
            String fileName = multipartFile.getOriginalFilename();      
            
            //get path
            String filePath = path +File.separator+fileName;

            //create folder
            File file = new File(path);

            if(!file.exists())
            {
                file.mkdir();
            }

            Files.copy(multipartFile.getInputStream(), Paths.get(filePath));
            ProductImage productImage = new ProductImage();
            productImage.setImageName(fileName);
            productImage.setProduct(product);

            newProduct = productRepository.save(product);
            productImageRepository.save(productImage);

        }

        return newProduct;
    }

    public List<Product> searchByName(String keyword) throws ResourceNotFoundException
    {
       List<Product> product = productRepository.findByProductNameContaining(keyword);
       if(product == null)
       {
            throw new ResourceNotFoundException(keyword);
       }

       return product;
    }
}