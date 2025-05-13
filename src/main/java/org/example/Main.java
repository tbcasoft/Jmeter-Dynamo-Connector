package org.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AttributeValue attributeValue = AttributeValue.builder().s("a117be75-ec1a-4fd5-98ac-8f1195ba5376").build();
        HashMap<String,AttributeValue> key_to_get =
                new HashMap<String, AttributeValue>();
        Map<String,AttributeValue> respItems;
        key_to_get.put("hivexRlId",attributeValue);
        Region region = Region.AP_NORTHEAST_1;
        GetItemResponse getItemResponse;
        GetItemRequest getItemRequest = GetItemRequest.builder().tableName("PPGW-TRANSACTION-TABLE").key(key_to_get).build();
        DynamoDbClient client = DynamoDbClient.builder().region(region).build();
        getItemResponse = client.getItem(getItemRequest);
        respItems=getItemResponse.item();

    System.out.println(respItems.get("paymentRequestId").n());
    }
}