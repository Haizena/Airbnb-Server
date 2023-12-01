package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter @NoArgsConstructor
public class DiscountDTO {
    public DiscountDTO(int discount_no, int house_no, Date dis_start_period, Date dis_end_period) {
        this.discount_no = discount_no;
        this.house_no = house_no;
        this.dis_start_period = dis_start_period;
        this.dis_end_period = dis_end_period;
    }

    public DiscountDTO(int house_no, Date dis_start_period, Date dis_end_period) {
        this.house_no = house_no;
        this.dis_start_period = dis_start_period;
        this.dis_end_period = dis_end_period;
    }

    private int house_no, discount_no;
    private Date dis_start_period, dis_end_period;
}
