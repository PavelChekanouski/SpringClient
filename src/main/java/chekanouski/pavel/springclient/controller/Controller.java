package chekanouski.pavel.springclient.controller;

import chekanouski.pavel.springclient.dto.Product;
import chekanouski.pavel.springclient.dto.ProductWithNumbers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@RestController
@RequestMapping("/app")
public class Controller {

    private List<Product> productList;
    private List<ProductWithNumbers> productWithNumbersList;

    @GetMapping("")
    public String start(){
        return "products";
    }

    @GetMapping("/products")
    public ResponseEntity<Product> productList() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.getForEntity("http://localhost:8083/getUnique/1", HashSet.class);
        productList = new ArrayList<>((HashSet<Product>)response.getBody());
        return response;
    }

    @GetMapping("/productsWithNumbers")
    public ResponseEntity<ProductWithNumbers> productWithNumbersList() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.getForEntity("http://localhost:8083/getUniqueWithNumbers/1", HashSet.class);
        productWithNumbersList = new ArrayList<>((HashSet<ProductWithNumbers>)response.getBody());
        return response;
    }

    @GetMapping("products/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productList.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
    }

    @GetMapping("products/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productList.stream().filter(f -> name.equals(f.getName())).findAny().orElse(null);
    }

    @GetMapping("productsWithNumbers/{name}")
    public ProductWithNumbers get(@PathVariable String name) {
        return productWithNumbersList.stream().filter(f -> name.equals(f.getName())).findAny().orElse(null);
    }
}

