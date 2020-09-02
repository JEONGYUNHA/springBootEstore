package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

	
	@RequestMapping
	public String getCart(Model model) {
		
		// 각 사용자별로 카트를 만드는 방법
		/*
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * String username = authentication.getName();
		 * 
		 * User user = userService.getUserByUsername {username}; 
		 * int cartId = user.getCart().getId();
		 * 
		 * model.addAttribute("cartId", cartId);
		 */
		
		
		// 우리는 카트를 사용자마다가 아니라 하나 지정해서 만들어줘서 이렇게 씀
		model.addAttribute("cartId", 1);
		return "cart";
	}
}
