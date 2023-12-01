package airbnb.server.persistence.DTO;

public class LoginedUser {
    public LoginedUser(User userType, int user_no) {
        this.userType = userType;
        this.user_no = user_no;
    }

    private User userType;
    private int user_no;

    public User getUserType() {
        return userType;
    }

    public int getUser_no() {
        return user_no;
    }
}
