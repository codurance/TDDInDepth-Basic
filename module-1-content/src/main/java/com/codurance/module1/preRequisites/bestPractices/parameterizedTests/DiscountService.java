package com.codurance.module1.preRequisites.bestPractices.parameterizedTests;

public class DiscountService {
    public boolean isDiscountAvailableFor(String email) {
        return true;
    }

    public boolean isDiscountAvailableFor(Product[] products) {
        return true;
    }

    public double calculateDiscount(int customerDiscountPercentage, int productsTotalPrice) {
        if (0 == customerDiscountPercentage) {
            return 0;
        }

        return (double) (customerDiscountPercentage * productsTotalPrice) / 100;
    }
}
