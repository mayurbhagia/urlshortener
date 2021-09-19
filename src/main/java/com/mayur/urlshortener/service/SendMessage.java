package com.mayur.urlshortener.service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.pinpoint.AmazonPinpoint;
import com.amazonaws.services.pinpoint.AmazonPinpointClientBuilder;
import com.amazonaws.services.pinpoint.model.AddressConfiguration;
import com.amazonaws.services.pinpoint.model.ChannelType;
import com.amazonaws.services.pinpoint.model.DirectMessageConfiguration;
import com.amazonaws.services.pinpoint.model.MessageRequest;
import com.amazonaws.services.pinpoint.model.SMSMessage;
import com.amazonaws.services.pinpoint.model.SendMessagesRequest;
import org.springframework.beans.factory.annotation.Value;


public class SendMessage {


    public static String messageType = "TRANSACTIONAL";

   // public static String registeredKeyword = "";
    //public static String senderId = "";
       @Value("${region}")
        private String region;

    public boolean sendSMS(String phonenumber, String url, String appId, String senderId, String registeredKeyword) {

        

       

        String originationNumber = "";
        String destinationNumber = phonenumber;

        System.out.println("Sending SMS " );


        //sendSMSMessage(pinpoint, message, appId, originationNumber, destinationNumber);

 try {               
            Map<String,AddressConfiguration> addressMap = 
                    new HashMap<String,AddressConfiguration>();
               
            addressMap.put(destinationNumber, new AddressConfiguration()
                    .withChannelType(ChannelType.SMS));
               
            AmazonPinpoint client = AmazonPinpointClientBuilder.standard()
                    .withRegion(region).build();
               
            SendMessagesRequest request = new SendMessagesRequest()
                    .withApplicationId(appId)
                    .withMessageRequest(new MessageRequest()
                    .withAddresses(addressMap)                                   
                    .withMessageConfiguration(new DirectMessageConfiguration()
                    .withSMSMessage(new SMSMessage()
                    .withBody(url)
                    .withMessageType(messageType)
                    .withOriginationNumber(originationNumber)
                    .withSenderId(senderId)
                    .withKeyword(registeredKeyword)
                            )
                    )
            );
            System.out.println("Sending message...");               
            client.sendMessages(request);
            System.out.println("Message sent!");
         return true;   
    } catch (Exception ex) {
        System.out.println("The message wasn't sent. Error message: " 
                + ex.getMessage());
        return false;
        }
  

    }
}

