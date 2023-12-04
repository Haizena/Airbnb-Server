package airbnb.server.persistence.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TotalSalesDTO implements Serializable {
    public TotalSalesDTO(int reservation_no, int totalAmount){
        this.reservation_no = reservation_no;
        this.totalAmount = totalAmount;
    }

    private int reservation_no, totalAmount;
}
