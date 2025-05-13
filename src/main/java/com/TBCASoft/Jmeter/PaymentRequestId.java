package com.TBCASoft.Jmeter;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

import java.util.HashMap;
import java.util.Map;

public class PaymentRequestId {
    public static String getPaymentRequestId(String rlId){
        AttributeValue attributeValue = AttributeValue.builder().s(rlId).build();
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
       return respItems.get("paymentRequestId").n();
    }
}
