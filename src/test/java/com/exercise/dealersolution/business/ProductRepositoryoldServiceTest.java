package com.exercise.dealersolution.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.exercise.dealersolution.model.ProductEntity;
import com.exercise.dealersolution.model.ProductSaida;
import com.exercise.dealersolution.repository.ProductRepository;
import com.exercise.dealersolution.repository.ProductRepositoryold;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exercise.dealersolution.service.ProductServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryoldControllerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServices productServices;


    @Test
    void shouldGetAllProducts() {

        final List<ProductSaida> retrievedObjects = productServices.findAll();

        assertTrue(retrievedObjects.isEmpty());
    }

}