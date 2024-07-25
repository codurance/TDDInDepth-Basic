package com.codurance.module1.preRequisites.bestPractices.parameterizedTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountServiceTest {

    private DiscountService discountservice;

    @BeforeEach
    public void setup() {
        discountservice = new DiscountService();
    }

    @Test
    public void shouldCheckDiscountAvailabilityForACustomer() {
        String[] emails = {"user@example.com", "another.user@domain.org", "name@domain.co"};

        for (String email : emails) {
            assertTrue(discountservice.isDiscountAvailableFor(email));
        }
    }

    @Test
    public void shouldCheckDiscountAvailabilityForProducts() {
        Collection<Product[]> productGroups = getProductGroups();

        for (Product[] products : productGroups) {
            assertTrue(discountservice.isDiscountAvailableFor(products));
        }
    }

    private Collection<Product[]> getProductGroups() {
        List<Product[]> productGroups = new ArrayList<>();
        productGroups.add(new Product[]{new Product(25), new Product(5)});

        return productGroups;
    }

    @Test
    public void shouldCalculateTotalDiscountForCustomerAndProducts() {
        List<int[]> paramsList = new ArrayList<>();
        paramsList.add(new int[]{15, 200, 30});
        paramsList.add(new int[]{15, 100, 15});
        paramsList.add(new int[]{15, 300, 45});
        paramsList.add(new int[]{25, 300, 75});

        for (int[] params : paramsList) {
            int customerDiscountPercentage = params[0];
            int productsTotalPrice = params[1];
            int expectedTotalDiscount = params[2];

            assertEquals(discountservice.calculateDiscount(
                customerDiscountPercentage,
                productsTotalPrice
            ), expectedTotalDiscount);
        }
    }
}
