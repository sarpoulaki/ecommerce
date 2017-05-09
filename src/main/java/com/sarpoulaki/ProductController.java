package com.sarpoulaki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sarpoulaki.model.Product;
import com.sarpoulaki.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired(required = true)
    @Qualifier(value="productService")
    public void setProductService(ProductService ps) {
        this.productService = ps;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("listProducts", this.productService.listProducts());
        return "home";
    }

    //For add and update product both
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product p) {

        if (p.getId() == 0) {
            //new product, add it
            this.productService.addProduct(p);
        } else {
            //existing product, call update
            this.productService.updateProduct(p);
        }

        return "redirect:/products";

    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id) {

        this.productService.removeProduct(id);
        return "redirect:/products";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
}

