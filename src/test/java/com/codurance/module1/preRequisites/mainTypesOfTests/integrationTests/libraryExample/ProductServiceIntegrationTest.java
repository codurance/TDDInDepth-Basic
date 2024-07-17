package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.libraryExample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductServiceIntegrationTest {

    @Test
    public void convertProductToJson() {
        Product product = new Product(1, "Television", "Perfect for watching Netflix", 300.0);
        String expectedJson = "{\"id\":1,\"name\":\"Television\",\"description\":\"Perfect for watching Netflix\",\"price\":300.0}";
        JacksonJsonMarshaller jsonMarshaller = new JacksonJsonMarshaller();
        ProductService productService = new ProductService(jsonMarshaller);

        String productAsJson = productService.convertToJson(product);

        assertEquals(expectedJson, productAsJson);
    }
}