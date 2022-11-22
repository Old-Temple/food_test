package foodtest.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="DeliveryHis_table")
@Data
public class DeliveryHis {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long menuId;
        private Long shopId;
        private Long customerId;
        private Integer price;
        private String customerAddress;
        private String shopAddress;


}