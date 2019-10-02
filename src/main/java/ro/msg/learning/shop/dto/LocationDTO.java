package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.Coordinates;

import javax.swing.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDTO {
    private Coordinates latLng;
    private String adminArea4;
    private String adminArea5Type; //CITY
    private String adminArea4Type; //COUNTY
    private String adminArea5;
    private String street;
    private Spring adminArea1;
    private String adminArea3;
    private Spring type;
    private Coordinates displayLatLng;
    private Integer linkId;
    private Integer postalCode;
    private String sideOfStreet;
    private boolean dragPoint;
    private String getAdminArea1Type;//COUNTRY
    private String geocodeQuality;//CITY
    private String getGeocodeQualityCode;
    private String adminArea3Type; //STATE

}
