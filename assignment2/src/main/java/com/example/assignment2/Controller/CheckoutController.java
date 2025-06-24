package com.example.assignment2.Controller;


import com.example.assignment2.Entity.Invoice;
import com.example.assignment2.Service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/{userId}")
    public Invoice checkout(@PathVariable int userId,
                            @RequestParam(defaultValue = "20") double discountRatePercent) {
        return checkoutService.checkout(userId, discountRatePercent);
    }
}
