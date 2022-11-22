package foodtest.domain;

import foodtest.domain.OrderCancled;
import foodtest.domain.OrderChecked;
import foodtest.domain.OrderConfirmed;
import foodtest.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private String customerAddress;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private Long shopId;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        foodtest.external.Payment payment = new foodtest.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext.getBean(foodtest.external.PaymentService.class)
            .payCancle(payment);


        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();



        OrderChecked orderChecked = new OrderChecked(this);
        orderChecked.publishAfterCommit();



        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();

        // Get request from Payment
        //foodtest.external.Payment payment =
        //    Application.applicationContext.getBean(foodtest.external.PaymentService.class)
        //    .getPayment(/** mapping value needed */);

    }
    @PreRemove
    public void onPreRemove(){
        // Get request from ShopOrder
        //foodtest.external.ShopOrder shopOrder =
        //    Application.applicationContext.getBean(foodtest.external.ShopOrderService.class)
        //    .getShopOrder(/** mapping value needed */);

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }



    public void order(){
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        foodtest.external.Payment payment = new foodtest.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext.getBean(foodtest.external.PaymentService.class)
            .pay(payment);

    }

    public static void updateStatus(AcceptOrder acceptOrder){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(acceptOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(RejectOrder rejectOrder){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejectOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(OrderConfirmed orderConfirmed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderConfirmed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
