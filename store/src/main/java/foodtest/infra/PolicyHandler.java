package foodtest.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import foodtest.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import foodtest.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired ShopOrderRepository shopOrderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AddOrder(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AddOrder : " + paid + "\n\n");


        

        // Sample Logic //
        ShopOrder.addOrder(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCancled'")
    public void wheneverPayCancled_DeleteOrder(@Payload PayCancled payCancled){

        PayCancled event = payCancled;
        System.out.println("\n\n##### listener DeleteOrder : " + payCancled + "\n\n");


        

        // Sample Logic //
        ShopOrder.deleteOrder(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderConfirmed'")
    public void wheneverOrderConfirmed_UpdateStatus(@Payload OrderConfirmed orderConfirmed){

        OrderConfirmed event = orderConfirmed;
        System.out.println("\n\n##### listener UpdateStatus : " + orderConfirmed + "\n\n");


        

        // Sample Logic //
        ShopOrder.updateStatus(event);
        

        

    }

}


