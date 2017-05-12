package com.sarpoulaki;

import com.sarpoulaki.model.Product;
import com.sarpoulaki.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired(required = true)
    @Qualifier(value="productService")
    public void setProductService(ProductService ps) {
        this.productService = ps;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView listProducts(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("user", session.getAttribute("user"));
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("listProducts", this.productService.listProducts());
        modelAndView.setViewName("product");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("user", session.getAttribute("user"));
        modelAndView.addObject("listProducts", this.productService.listProducts());
        modelAndView.setViewName("home");
        return modelAndView;
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
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("product", this.productService.getProductById(id));
        modelAndView.addObject("listProducts", this.productService.listProducts());
        Map<String, Object> mm = modelAndView.getModel();
//        mm.keySet()
        modelAndView.setViewName("product");
        return modelAndView;
    }
}

