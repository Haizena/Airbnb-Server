package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class AmountDiscountDTO extends DiscountDTO {
    public AmountDiscountDTO(int discount_no, int house_no, Date dis_start_period, Date dis_end_period, int amount) {
        super(discount_no, house_no, dis_start_period, dis_end_period);
        this.amount = amount;
    }

    public AmountDiscountDTO(int house_no, Date dis_start_period, Date dis_end_period) {
        super(house_no, dis_start_period, dis_end_period);
    }

    public AmountDiscountDTO(int house_no, Date dis_start_period, Date dis_end_period, int amount) {
        super(house_no, dis_start_period, dis_end_period);
        this.amount = amount;
    }

    private int amount;
}
