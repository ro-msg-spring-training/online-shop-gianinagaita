package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.DetailResponse;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DistanceResponseDTO {
    private boolean allToAll;
    private List<Long> distance;
    private List<Long> time;
    private LocationDTO locationDTO;
    private boolean manyToOne;
    private DetailResponse info;

}
