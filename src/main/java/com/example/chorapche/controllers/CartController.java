package com.example.chorapche.controllers;

import com.example.chorapche.model.dto.CartItemDTO;
import com.example.chorapche.service.CartService;
import com.example.chorapche.service.ProductService;
import com.example.chorapche.session.CurrentOrder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CartController {

    private final ProductService productService;
    private final CartService cartService;
    private final CurrentOrder currentOrder;

    @Autowired
    public CartController(ProductService productService,
                          CartService cartService, CurrentOrder currentOrder) {
        this.productService = productService;
        this.cartService = cartService;
        this.currentOrder = currentOrder;
    }

    @ModelAttribute(name = "carItemDTO")
    public CartItemDTO cartItemDTOInit() {
    return new CartItemDTO();
    }

    @GetMapping("/cart")
    public String getCart(Model model){

        model.addAttribute("cartItems",this.currentOrder.getCartItemList());
        model.addAttribute("totalCost",this.cartService.calculateTotalCost());
        return "cart";
    }
    @PostMapping("/add-product")
    public String postAddProduct(@Valid CartItemDTO cartItemDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()||
                !this.productService.isProductNameValid(cartItemDTO.getProductName())){
            return "redirect:/";
        }

        this.cartService.addCartItem(cartItemDTO);

        redirectAttributes.addFlashAttribute("alertMessage",true);

        return "redirect:/";
    }
    @GetMapping("/cart/delete-product/{productName}")
    public String productDetails(@PathVariable("productName") String productName) {
        this.cartService.deleteCartItem(productName);

        return "redirect:/cart";
    }
}
