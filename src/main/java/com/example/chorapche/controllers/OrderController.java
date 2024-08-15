package com.example.chorapche.controllers;

import com.example.chorapche.model.dto.OrderInfoDTO;
import com.example.chorapche.service.CartService;
import com.example.chorapche.service.OrderService;
import com.example.chorapche.session.CurrentOrder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    private final CartService cartService;
    private final CurrentOrder currentOrder;
    private final OrderService orderService;

    @Autowired
    public OrderController(CartService cartService, CurrentOrder currentOrder, OrderService orderService) {
        this.cartService = cartService;
        this.currentOrder = currentOrder;
        this.orderService = orderService;
    }

    @ModelAttribute(name = "orderInfoDTO")
    public OrderInfoDTO orderInfoDTOInit(){return new OrderInfoDTO();}

    @GetMapping("/order-info")
    public String getOrderInfo(Model model){
        if(this.currentOrder.getCartItemList().isEmpty()){
            return "redirect:/";
        }
        model.addAttribute("totalCost",cartService.calculateTotalCost());
        return"customer-form";
    }
    @GetMapping("/success")
    public String getSuccessfulOrder(Model model){
        if(this.currentOrder.getCartItemList().isEmpty()){
            return "redirect:/";
        }

        model.addAttribute("totalSum", this.cartService.calculateTotalCostPlusDelivery());
        this.currentOrder.reset();
        return "success";
    }

    @PostMapping("/finish-order")
    public String postFinishOrder(@Valid OrderInfoDTO orderInfoDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("orderInfoDTO",orderInfoDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderInfoDTO",
                    bindingResult);

            return "redirect:/order-info";

        }
        this.orderService.addOrder(orderInfoDTO);
return "redirect:/success";
    }
}
