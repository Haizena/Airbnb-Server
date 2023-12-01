package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ReviewDTO {
    public ReviewDTO(int reservation_no, String comment, double star){
        this.reservation_no = reservation_no;
        this.comment = comment;
        this.star = star;
    }
    public ReviewDTO(int reservation_no, String comment, int parent_no) {
        this.parent_no = parent_no;
        this.reservation_no = reservation_no;
        this.comment = comment;
    }

    public ReviewDTO(int review_no, int reservation_no, String comment, int parent_no, double star) {
        this(reservation_no, comment, parent_no);
        this.star = star;
        this.review_no = review_no;
    }

    private int review_no, reservation_no, parent_no;
    private double star;
    private String comment;
}
