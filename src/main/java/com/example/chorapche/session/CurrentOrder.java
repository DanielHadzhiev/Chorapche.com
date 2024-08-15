package com.example.chorapche.session;

import com.example.chorapche.model.entity.CartItem;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentOrder {

   private List<CartItem> cartItemList;


    public CurrentOrder() {
        this.cartItemList = new ArrayList<>();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

public void reset(){
        this.cartItemList=new ArrayList<>();
}
}
