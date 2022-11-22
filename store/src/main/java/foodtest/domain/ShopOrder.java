package foodtest.domain;

import foodtest.domain.AcceptOrder;
import foodtest.domain.RejectOrder;
import foodtest.domain.StartCooking;
import foodtest.domain.EndCooking;
import foodtest.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="ShopOrder_table")
@Data

public class ShopOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Long shopId;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        AcceptOrder acceptOrder = new AcceptOrder(this);
        acceptOrder.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        foodtest.external.Payment payment = new foodtest.external.Payment();
        // mappings goes here
        StoreApplication.applicationContext.getBean(foodtest.external.PaymentService.class)
            .payCancle(payment);


        RejectOrder rejectOrder = new RejectOrder(this);
        rejectOrder.publishAfterCommit();



        StartCooking startCooking = new StartCooking(this);
        startCooking.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        foodtest.external.Delivery delivery = new foodtest.external.Delivery();
        // mappings goes here
        StoreApplication.applicationContext.getBean(foodtest.external.DeliveryService.class)
            .accept(delivery);


        EndCooking endCooking = new EndCooking(this);
        endCooking.publishAfterCommit();

    }

    public static ShopOrderRepository repository(){
        ShopOrderRepository shopOrderRepository = StoreApplication.applicationContext.getBean(ShopOrderRepository.class);
        return shopOrderRepository;
    }




    public static void addOrder(Paid paid){

        
        repository().findById(paid.getId()).ifPresent(shopOrder->{
            //결제값이 만원 이상이여야 주문확인됨
            if(paid.getPrice() > 10000) {
                shopOrder.setMenuId(paid.getMenuId());
                repository().save(shopOrder);
            }
         });

        
    }
    public static void deleteOrder(PayCancled payCancled){

        
        repository().findById(payCancled.getId()).ifPresent(shopOrder->{
            
            shopOrder.setMenuId(null);
            repository().save(shopOrder);
         });

        
    }
    public static void updateStatus(OrderConfirmed orderConfirmed){

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderConfirmed.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

        
    }


}
