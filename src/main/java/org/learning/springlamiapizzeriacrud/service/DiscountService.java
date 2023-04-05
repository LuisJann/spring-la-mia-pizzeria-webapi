package org.learning.springlamiapizzeriacrud.service;

import org.learning.springlamiapizzeriacrud.model.Discount;
import org.learning.springlamiapizzeriacrud.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    @Autowired
    DiscountRepository discountRopository;

    public Discount create(Discount fomrDiscount) {
        return discountRopository.save(fomrDiscount);
    }
}
