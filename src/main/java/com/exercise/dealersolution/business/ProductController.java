package com.exercise.dealersolution.business;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exercise.dealersolution.model.ProductEntrada;
import com.exercise.dealersolution.model.ProductSaida;
import com.exercise.dealersolution.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dealer")
public class ProductController {

  @Autowired
  ProductServices productServices;


  public ProductController() {
  }

  @GetMapping("/models")
  public List<ProductSaida> retrieveAll() {
    return productServices.findAll();
  }

  @GetMapping("/models/available")
  public List<ProductSaida> getAll() {

    return productServices.findAvaliables();
  }

  @GetMapping("/models/{id}")
  public String retrieveDeadline(@PathVariable String id) {

    return productServices.findDeadLine(id);
  }

  @PostMapping("/models/new")
  public void addNewProductModel( @RequestBody ProductEntrada s) {
    productServices.save(s);
  }

  @PostMapping("/models")
  public void apagarItens(@RequestBody List<ProductEntrada> productEntrada) {

    productServices.deleteItens(productEntrada);
  }

  @PostMapping("/models/{produto}")
  public void delete(@PathVariable ProductEntrada produto) {

    productServices.deleteItem(produto);
  }

  @PatchMapping("/model/{id}")
  public void updateProduct(@RequestBody ProductEntrada product) {
    productServices.updateProduct(product);
  }

  @PutMapping("/model/{id}/{price}")
  public void updateProductPrice(@PathVariable Long productModelId, @PathVariable Double price) {
    productServices.updateProductPrice(productModelId,price);
  }

  @GetMapping("/model/orderbydeadline")
  public List<ProductSaida> buscarDeadLineOrdenado(){
    return productServices.findaAllByDeadLineOerder();
  }

  @GetMapping("/model/orderbyitens")
  public List<ProductSaida> buscarItensOrdenado(){
    return productServices.findaAllByItensOerder();
  }

  @GetMapping("/model/orderbyprice")
  public List<ProductSaida> buscarpriceOrdenado(){
    return productServices.findaAllBypriceOerder();
  }
}
