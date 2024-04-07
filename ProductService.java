package com.riyabhurse.productservices.Services;

import com.riyabhurse.productservices.Models.Product;
import com.riyabhurse.productservices.dto.FakeProductStoretDto;

import java.util.List;

public interface ProductService {
      Product getProductById(Long id);
      List<Product> getAllProducts();
}
