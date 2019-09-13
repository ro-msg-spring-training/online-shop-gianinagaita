package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable @Data
    public class OrderDetailKey implements Serializable {
        @Column(name ="Product_id")
        Long productid;
        @Column(name = "Ordeer_id")
        Long  ordeerid;
    }

