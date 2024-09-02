package com.divi.product.management.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.divi.product.management.models.product;

public interface productRepository extends MongoRepository<product, String> {

}
