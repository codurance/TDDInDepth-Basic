package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.libraryExample;

public class ProductService {
    private final JsonMarshaller jsonMarshaller;

    public ProductService(JsonMarshaller jsonMarshaller) {
        this.jsonMarshaller = jsonMarshaller;
    }

    public String convertToJson(Product product) {
        return jsonMarshaller.marshal(product);
    }
}
