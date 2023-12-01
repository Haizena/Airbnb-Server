package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserDTO {
    private String name, phoneNum, id, pw;
    private int dateOfBirth, userNo;
    private User role;

    public UserDTO(String name, String phoneNum, int dateOfBirth, String id, String pw, User role){
        this.name = name;
        this.phoneNum = phoneNum;
        this.id = id;
        this.pw = pw;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
    public UserDTO(int userNo, String name, String phoneNum, int dateOfBirth, String id, String pw, User role){
        this.name = name;
        this.phoneNum = phoneNum;
        this.id = id;
        this.pw = pw;
        this.dateOfBirth = dateOfBirth;
        this.userNo = userNo;
        this.role = role;
    }
}


