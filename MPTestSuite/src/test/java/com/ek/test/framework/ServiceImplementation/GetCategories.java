package com.ek.test.framework.ServiceImplementation;

import com.ek.test.framework.model.apiCategories.Children_data;
import com.ek.test.framework.model.apiCategories.categories;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.jayway.restassured.internal.mapping.Jackson2Mapper;
import com.jayway.restassured.mapper.factory.JAXBObjectMapperFactory;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import javax.xml.bind.JAXBContext;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Administrator on 9/11/2016.
 */
public class GetCategories {
    public static void callRESTAPIGetCategories() throws Exception {
        try{
            RequestSpecification header = given().header("content-Type","application/json");
            Response response = header.when().get("http://magento-dev.atg.digital/rest/default/V1/categories");
            //ScenarioHook.getScenario().write(response.prettyPrint());
            System.out.println(response.prettyPrint());
            String responseStr = response.asString();
            /*ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

            objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
            objectMapper.configure(DeserializationFeature.WRAP_EXCEPTIONS, false);
            categories children_data = objectMapper.readValue(response.asString(), categories.class);*/
            //JSONObject jObj = new JSONObject("responseStr");
/*            JsonObject obj = new JsonParser().parse(responseStr).getAsJsonObject();
            //obj.members.get("children_data")
            JsonElement children = obj.get("children_data");
            int count = ((JsonArray) children).size();
            JsonElement xx = ((JsonArray) children).get(0);
            JsonElement yy = ((JsonObject) xx).get("children_data");
            LinkedTreeMap<String, String> childrens = new LinkedTreeMap<>();
            JsonArray dfdfd = ((JsonObject) xx).get("children_data").getAsJsonArray();*/

            JaxbAnnotationModule module = new JaxbAnnotationModule();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(module);

            Children_data root = objectMapper.readValue(responseStr, Children_data.class);

            categories cat = new ObjectMapper().readValue(responseStr,categories.class);

            JaxbAnnotationModule jba = new JaxbAnnotationModule();





            System.out.println();
        }catch (Exception e){
            throw new Exception("");
        }
    }

    public static void main(String[] args) throws Exception {
        callRESTAPIGetCategories();
    }
}
