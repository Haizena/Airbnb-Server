package airbnb.server.persistence.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PayMentDTO implements Serializable {
    public PayMentDTO(int house_no, int weekday_pay, int weekend_pay){
        this(weekday_pay,weekend_pay);
        this.house_no = house_no;
    }
    public PayMentDTO(int weekday_pay, int weekend_pay){
        this.weekday_pay = weekday_pay;
        this.weekend_pay = weekend_pay;
    }

    private int house_no;
    private int weekday_pay;
    private int weekend_pay;
}
