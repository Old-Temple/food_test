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
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='AcceptOrder'")
    public void wheneverAcceptOrder_UpdateStatus(@Payload AcceptOrder acceptOrder){

        AcceptOrder event = acceptOrder;
        System.out.println("\n\n##### listener UpdateStatus : " + acceptOrder + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RejectOrder'")
    public void wheneverRejectOrder_UpdateStatus(@Payload RejectOrder rejectOrder){

        RejectOrder event = rejectOrder;
        System.out.println("\n\n##### listener UpdateStatus : " + rejectOrder + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_UpdateStatus(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener UpdateStatus : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderConfirmed'")
    public void wheneverOrderConfirmed_UpdateStatus(@Payload OrderConfirmed orderConfirmed){

        OrderConfirmed event = orderConfirmed;
        System.out.println("\n\n##### listener UpdateStatus : " + orderConfirmed + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }

}


