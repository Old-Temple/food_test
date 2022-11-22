package foodtest.infra;

import foodtest.domain.*;
import foodtest.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryHisViewHandler {


    @Autowired
    private DeliveryHisRepository deliveryHisRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_CREATE_1 (@Payload DeliveryStarted deliveryStarted) {
        try {

            if (!deliveryStarted.validate()) return;

            // view 객체 생성
            DeliveryHis deliveryHis = new DeliveryHis();
            // view 객체에 이벤트의 Value 를 set 함
            deliveryHis.setId(deliveryStarted.getId());
            deliveryHis.setMenuId(deliveryStarted.getMenuId());
            deliveryHis.setShopId(deliveryStarted.getShopId());
            deliveryHis.setCustomerId(deliveryStarted.getCustomerId());
            deliveryHis.setPrice(deliveryStarted.getPrice());
            deliveryHis.setCustomerAddress(deliveryStarted.getCustomerAddress());
            deliveryHis.setShopAddress(deliveryStarted.getShopAddress());
            // view 레파지 토리에 save
            deliveryHisRepository.save(deliveryHis);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

