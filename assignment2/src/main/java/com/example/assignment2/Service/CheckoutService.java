package com.example.assignment2.Service;

import com.example.assignment2.Entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckoutService {
    public CartService cartService;
    public ProductService productService;
    public OrderService orderService;
    public InvoiceService invoiceService;

    public CheckoutService(CartService cartService,
                           ProductService productService,
                           OrderService orderService,
                           InvoiceService invoiceService) {
        this.cartService = cartService;
        this.productService = productService;
        this.orderService = orderService;
        this.invoiceService = invoiceService;
    }

    public Invoice checkout(int userId, double discountRatePercent) {
        Cart cart = cartService.getCartByUserId(userId);
        List<CartItem> cartItems = cartService.getItems(cart.getId());

        double total = 0;
        double discount = 0;

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(LocalDateTime.now());
        orderService.createOrder(order);
        for (CartItem item : cartItems) {
            Product product = productService.getById(item.getProductID());

            double itemTotal = item.getQuantity() * product.getPrice();
            double itemDiscount = 0;

            if (productService.isNearExpiry(product)) {
                double rate = discountRatePercent / 100.0;
                itemDiscount = itemTotal * rate;
                itemTotal -= itemDiscount;
            }

            discount += itemDiscount;
            total += itemTotal;

            orderService.addOrderItem(new OrderItem(order.getId(), product.getId(), item.getQuantity(), product.getPrice(), itemTotal / item.getQuantity()));
        }

        order.setTotalAmount(total);

        Invoice invoice = new Invoice();
        invoice.setOrderId(order.getId());
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setTotalAmount(total + discount);
        invoice.setDiscountApplied(discount);
        invoice.setFinalAmount(total);

        invoiceService.generateInvoice(invoice);

        return invoice;
    }

}

