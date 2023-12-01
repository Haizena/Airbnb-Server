package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter @NoArgsConstructor
public class RateDiscountDTO extends DiscountDTO{
    public RateDiscountDTO(int discount_no, int house_no, Date dis_start_period, Date dis_end_period, double rate) {
        super(discount_no, house_no, dis_start_period, dis_end_period);
        this.rate = rate;
    }
    public RateDiscountDTO(int house_no, Date dis_start_period, Date dis_end_period) {
        super(house_no, dis_start_period, dis_end_period);
    }

    public RateDiscountDTO(int house_no, Date dis_start_period, Date dis_end_period, double rate) {
        super(house_no, dis_start_period, dis_end_period);
        this.rate = rate;
    }

    private double rate;
}
