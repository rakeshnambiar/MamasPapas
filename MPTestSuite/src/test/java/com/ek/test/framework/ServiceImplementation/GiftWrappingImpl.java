package com.ek.test.framework.ServiceImplementation;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;

import com.jayway.restassured.specification.RequestSpecification;
import com.magentoGift.Item;

import java.util.*;

import static com.jayway.restassured.RestAssured.given;

public class GiftWrappingImpl {
    private static Item item;

    public static void callRESTAPIGiftWrapper() throws Exception {
        try{
            RequestSpecification header = given().header("Accept","application/json").and()
                    .header("content-Type","application/json");
            header.auth().oauth("98ues8ev9h4483lakbkv5d3iol0h4cv2","3r0atn649l383pn9p9ho4qdismnm4pth","v0c6arxqo8pu54s4xqwjh5nt6nnkfupy","g17mq5w59v9epkt92m0cd4v10rh3vudf");
            Response response = header.when().get("http://magento-dev.atg.digital/rest/default/V1/gift-wrappings?searchCriteria[filterGroups][0][filters][0][field]=status&searchCriteria[filterGroups][0][filters][0][value]=1");
            int responseCode = response.getStatusCode();
            System.out.println(response.prettyPrint());
            item = new ObjectMapper().readValue(response.asString(), Item.class);
            getItemsCount();
        }catch (Exception e){
            throw new Exception("ERROR: While hitting the Gift Wrapper REST API");
        }
    }

    public static void main(String[] args) throws Exception {
        callRESTAPIGiftWrapper();

    }

    public static int getItemsCount() throws Exception {
        int count = 0;
        try{
            if(item.getAdditionalProperties().size() > 0){
                ArrayList<String> items = new ArrayList<String>();
                items = (ArrayList<String>) item.getAdditionalProperties().get("items");
                System.out.println(item.getAdditionalProperties().get("items").toString());
                 Set<String> itemsDetail =  item.getAdditionalProperties().keySet();
               /* Iterator<String> keyIterator = items.keySet().iterator();
                while(keyIterator.hasNext()){
                    String key = keyIterator.next();
                    System.out.println();
                }*/
                System.out.println();
            }
        }catch (Exception e){
            throw new Exception("ERROR: While Getting the Item Count from Gift Wrapper REST API");
        }
        return count;
    }
}
