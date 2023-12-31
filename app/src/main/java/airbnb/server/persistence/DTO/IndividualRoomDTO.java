package airbnb.server.persistence.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class IndividualRoomDTO implements Serializable {

    public IndividualRoomDTO(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public IndividualRoomDTO(int house_no, int roomNumber) {
        this.house_no = house_no;
        this.roomNumber = roomNumber;
    }

    private int house_no, roomNumber;
}
