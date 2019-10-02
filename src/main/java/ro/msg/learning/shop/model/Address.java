package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String Country;
    private String City;
    private String County;
    private String StreetAddress;

}
