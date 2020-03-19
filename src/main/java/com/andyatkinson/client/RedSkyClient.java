package com.andyatkinson.client;

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class RedSkyClient {
    private static final String PRODUCT_DATA_ENDPOINT =
            "http://redsky.target.com/v2/pdp/tcin/13860428?excludes=" +
            "taxonomy,price,promotion,bulk_ship,rating_and_review_reviews," +
            "rating_and_review_statistics,question_answer_statistics";

    public RedSkyProduct getRedSkyProduct() {
        String title = new String();

        try {
            HttpResponse<JsonNode> resp = Unirest.get(PRODUCT_DATA_ENDPOINT).
                    header("accept", "application/json").
                    asJson();

            String json = resp.getBody().toString();

            title = JsonPath.read(json, "$.product.item.product_description.title");
        } catch (Exception e) {
            // log an exception finding or parsing the title
        }

        return new RedSkyProduct(title);
    }

}
