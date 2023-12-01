package airbnb.server.persistence.request.type;

public enum UserRequest implements RequestType {
    LOGIN_TYPE(7, 0x01),
    INSERT_USER(7, 0x02),
    MODIFY_USER(7, 0x03),
    MODIFY_PW(7, 0x04),
    GET_PW(7, 0x05);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private UserRequest(int type, int value) {
        this.type = type;
        this.value = value;
    }

    public int type() {
        return this.type;
    }

    public int value() {
        return this.value;
    }

    public String getName() {
        return this.name();
    }
}
