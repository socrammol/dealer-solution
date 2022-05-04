package com.exercise.dealersolution.service;

import com.exercise.dealersolution.exception.ProdutoNaoEncontradoException;
import com.exercise.dealersolution.model.ProductEntity;
import com.exercise.dealersolution.model.ProductEntrada;
import com.exercise.dealersolution.model.ProductSaida;
import com.exercise.dealersolution.repository.ProductRepository;
import com.exercise.dealersolution.repository.ProductRepositoryold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ProductServices {
    private static final Long AVALIABE_PRODUCT = 2L;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductSaida> findAll() {
        List<ProductSaida> productSaidas = new ArrayList();
        List <ProductEntity> productEntities = (List<ProductEntity>) productRepository.findAll();
        productEntities.forEach(entity -> {
            ProductSaida productSaida = new ProductSaida(entity);
            productSaidas.add(productSaida);
        });
        return productSaidas;
    }

    public List<ProductSaida> findAvaliables() {

        return productRepository.findByStatus(AVALIABE_PRODUCT);
    }

    public String findDeadLine(String id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Optional<ProductEntity> productEntity = productRepository.findById(Long.valueOf(id));
        if(productEntity.isPresent()){
            return productEntity.get().getDeadline().format(formatter);
        }
        throw new ProdutoNaoEncontradoException();

    }

    public void save(ProductEntrada productEntrada) {
        ProductEntity productEntity = new ProductEntity(productEntrada);
        productRepository.save(productEntity);
    }

    public void deleteItens(List<ProductEntrada> productEntrada) {
        productEntrada.forEach(product ->{
            productRepository.deleteById(product.getId());
        });

    }

    public void deleteItem(ProductEntrada produto) {
        productRepository.deleteById(produto.getId());
    }

    public void updateProduct(ProductEntrada product) {
        ProductEntity productEntity = new ProductEntity(product);
        productRepository.save(productEntity);
    }

    public void updateProductPrice(Long productModelId, Double price) {
        Optional<ProductEntity> productEntity = productRepository.findById(productModelId);
        if(productEntity.isPresent()){
            productEntity.get().setPrice(price);
            productRepository.save(productEntity.get());
        }
    }

    public List<ProductSaida> findaAllByDeadLineOerder() {

        return productRepository.findAllByOrderByDeadlineAsc();
    }

    public List<ProductSaida> findaAllByItensOerder() {
        return productRepository.findAllByOrderByQuantityAsc();
    }

    public List<ProductSaida> findaAllBypriceOerder() {
        return productRepository.findAllByOrderByPriceAsc();
    }
}
