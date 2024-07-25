package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.libraryExample;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductServiceShould {
    @Test
    public void invokeMarshallJsonWhenConvertToJsonCalled() {
        Product product = new Product(1, "Television", "Perfect for watching Netflix", 300.00);
        JsonMarshaller jsonMarshaller = mock(JsonMarshaller.class);

        ProductService productService = new ProductService(jsonMarshaller);

        productService.convertToJson(product);

        verify(jsonMarshaller).marshal(product);
    }
}