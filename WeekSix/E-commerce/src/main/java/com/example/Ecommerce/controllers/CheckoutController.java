package com.example.Ecommerce.controllers;

import com.example.Ecommerce.model.ChargeRequest;
import com.example.Ecommerce.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class CheckoutController {

    @Autowired
    private StripeService paymentsService;

    @PostMapping(value = "/charge")
    public String Charge(ChargeRequest chargeRequest, Model model)
            throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }
    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex){
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
