package org.learning.springlamiapizzeriacrud.controller;

import jakarta.validation.Valid;
import org.learning.springlamiapizzeriacrud.model.Discount;
import org.learning.springlamiapizzeriacrud.model.Pizza;
import org.learning.springlamiapizzeriacrud.service.DiscountService;
import org.learning.springlamiapizzeriacrud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Controller
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/create")
    public String create(@RequestParam(name = "pizzaId") Integer id, Model model) {
        Discount discount = new Discount();
        discount.setStartDiscount(LocalDate.now());
        discount.setEndDiscount(LocalDate.now().plusMonths(1));

        try {
            Pizza pizza = pizzaService.getById(id);
            discount.setPizza(pizza);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("discount", discount);
        return "/discounts/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute Discount formdiscount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/discounts/create";
        }
        Discount createDiscount = discountService.create(formdiscount);
        return "redirect:/pizzas/" + Integer.toString(createDiscount.getPizza().getId());
    }
}
