package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter @Setter @NoArgsConstructor
public class ReservationDTO implements Serializable {
    public ReservationDTO(int host_no, int guest_no, int house_no, int people_num, Date check_in, Date check_out, boolean isReviewed, boolean isApproved) {
        this.host_no = host_no;
        this.guest_no = guest_no;
        this.house_no = house_no;
        this.people_num = people_num;
        this.check_in = check_in;
        this.check_out = check_out;
        this.isReviewed = isReviewed;
        this.isApproved = isApproved;
    }

    public ReservationDTO(int reservation_no, int host_no, int guest_no, int house_no, int people_num, Date check_in, Date check_out, boolean isReviewed, boolean isApproved) {
        this(host_no, guest_no, house_no, people_num, check_in, check_out, isReviewed, isApproved);
        this.reservation_no = reservation_no;
    }

    private int reservation_no, host_no, guest_no, house_no, people_num;
    private Date check_in, check_out;
    private boolean isReviewed, isApproved, isCheckOuted;
}
