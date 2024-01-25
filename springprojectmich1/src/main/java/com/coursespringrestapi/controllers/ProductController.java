package com.coursespringrestapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coursespringrestapi.dtos.ProductRecordDto;
import com.coursespringrestapi.models.ProductModel;
import com.coursespringrestapi.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	

	@PostMapping("/products")
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productRecordDto, productModel); //Do a convert dto to model
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
	}
	
	

	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
	}
	
	
	
	
}
