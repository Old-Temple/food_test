package foodtest.domain;

import foodtest.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Log_table")
@Data

public class Log  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private String message;


    public static LogRepository repository(){
        LogRepository logRepository = CustomerApplication.applicationContext.getBean(LogRepository.class);
        return logRepository;
    }




    public static void kakaoAlert(Paid paid){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void kakaoAlert(PayCancled payCancled){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCancled.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void kakaoAlert(AcceptOrder acceptOrder){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(acceptOrder.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void kakaoAlert(RejectOrder rejectOrder){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejectOrder.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void kakaoAlert(DeliveryStarted deliveryStarted){

        repository().findById(deliveryStarted.getId()).ifPresent(log->{
            //일정시간이 지난 후에 확인하였을 때 여전히 메세지가 배달시작이라면 사고남으로 정정
            log.setMessage("배달시작");
            repository().save(log);

            try {
                Thread.currentThread().sleep((long) 600000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            if(log.getMessage().equals("배달시작")){
                log.setMessage("사고남");
                repository().save(log);
            }

         });
    }
    public static void kakaoAlert(StartCooking startCooking){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(startCooking.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void kakaoAlert(EndCooking endCooking){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(endCooking.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }


}
