package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseDTO {
    private int house_no, maxMember, host, houseconve, bedroom, bed, bathroom;
    private String houseName, address, introduction;
    private boolean managerApproved;

    public HouseDTO(String houseName, String address, int maxMember, String introduction, int host, int houseconve, int bedroom, int bed, int bathroom) {
        this.house_no = 0;
        this.houseName = houseName;
        this.address = address;
        this.maxMember = maxMember;
        this.introduction = introduction;
        this.host = host;
        this.houseconve = houseconve;
        this.bedroom = bedroom;
        this.bed = bed;
        this.bathroom = bathroom;
    }

    public HouseDTO(String houseName, String address, int maxMember, String introduction, int host, int houseconve, boolean managerApproved, int bedroom, int bed, int bathroom) {
        this(houseName, address, maxMember, introduction, host, houseconve, bedroom, bed, bathroom);
        this.managerApproved = managerApproved;
    }

    public HouseDTO(int house_no, String houseName, String address, int maxMember, String introduction, int host, int houseconve, int bedroom, int bed, int bathroom, boolean managerApproved) {
        this(houseName, address, maxMember, introduction, host, houseconve, managerApproved, bedroom, bed, bathroom);
        this.house_no = house_no;
    }
}
