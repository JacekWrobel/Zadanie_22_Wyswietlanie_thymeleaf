package pl.jwr.table;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam String priceS) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(priceS)) return "redirect:/err.html";
        else {
            double price = Double.valueOf(priceS);
            List<Product> productsList = productRepository.getAll();
            Product newProduct = new Product(name, price);
            productsList.add(newProduct);
            return "redirect:/list";
        }
    }

    @GetMapping("/table")
    public String tableOfProducts(Model model) {
        List<Product> products = new ArrayList<>();
        products = productRepository.getAll();

        model.addAttribute("products", products);
        model.addAttribute("sum", productRepository.sumOfProducts());
        return "table";
    }

    @GetMapping("/list")
    public String listOfProduct(Model model) {
        List<Product> products = new ArrayList<>();
        products = productRepository.getAll();

        model.addAttribute("products", products);
        model.addAttribute("sum", productRepository.sumOfProducts());
        return "list";
    }


}
