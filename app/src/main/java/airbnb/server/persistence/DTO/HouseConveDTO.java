package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class HouseConveDTO {
    public HouseConveDTO(int basic_no, int manysearch_no, int safety_no, int access_no) {
        this.basic_no = basic_no;
        this.manysearch_no = manysearch_no;
        this.safety_no = safety_no;
        this.access_no = access_no;
    }

    public HouseConveDTO(int basic_no, int manysearch_no, int safety_no, int access_no, int houseconve_no) {
        this(basic_no, manysearch_no, safety_no, access_no);
        this.houseconve_no = houseconve_no;
    }

    private int basic_no, manysearch_no, safety_no, access_no, houseconve_no;
}
