package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
public class ProductController { // controller -> service -> dao
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		
		List<Product> products = productService.getProducts();
		
		model.addAttribute("products",products);
		
		return "products"; // view's logical name -> products.jsp로 넘겨주면 실제로 여기서 model에 있는걸 가지고 출력을 해준다.
	}

	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) {
		
		Product product = productService.getProductById(productId);
		
		model.addAttribute("product", product);
		
		return "viewProduct";
	}
}
