package airbnb.server.persistence.DTO;

public enum User {
    host, guest, manager;
    int userNo;

    User(){

    }
    User(User user, int userNo){

    }
    int getUserNo(){
        return userNo;
    }
}
