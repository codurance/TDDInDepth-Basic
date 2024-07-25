package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.libraryExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonMarshaller  implements JsonMarshaller {
    @Override
    public String marshal(Object object) {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
