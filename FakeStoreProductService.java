package com.riyabhurse.productservices.Services;

import com.riyabhurse.productservices.Models.Category;
import com.riyabhurse.productservices.Models.Product;
import com.riyabhurse.productservices.dto.FakeProductStoretDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeProductStoretDto fakeProductStoretDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,FakeProductStoretDto.class);
        if(fakeProductStoretDto==null) return null;
        return convertFakeProductToProduct(fakeProductStoretDto);
    }
    public Product convertFakeProductToProduct(FakeProductStoretDto fakeProductStoretDto){
        Product product = new Product();
        product.setId(fakeProductStoretDto.getId());
        product.setTitle(fakeProductStoretDto.getTitle());
        product.setDescription(fakeProductStoretDto.getDescription());
        product.setImage(fakeProductStoretDto.getImage());
        Category category = new Category();
        category.setId(fakeProductStoretDto.getId());
        return product;
    }
    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeProductStoretDto[] fakeProductStoretDtos = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeProductStoretDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeProductStoretDto fakeProductStoretDto :  fakeProductStoretDtos){
            products.add(convertFakeProductToProduct(fakeProductStoretDto));
        }
        return products;
    }
}



