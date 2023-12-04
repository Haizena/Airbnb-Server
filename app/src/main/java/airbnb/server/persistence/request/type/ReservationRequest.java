package airbnb.server.persistence.request.type;

public enum ReservationRequest implements RequestType {
    INSERT_RESERVATION(5, 0x01),
    RECENT_ADDED_RESERVATION_NO(5, 0x02),
    REVIEWED(5, 0x03),
    APPROVED(5, 0x04),
    CHECKOUTED(5, 0x05),
    UNCHECKOUTED(5, 0x06),
    SELECT_HOST(5, 0x07),
    SELECT_GUEST(5, 0x08),
    SELECT_APPROVED_GUEST(5, 0x09),
    SELECT_UNREVIEWED_CHECKOUT(5, 0x0A),
    ALL_APPROVED_LIST(5, 0x0B),
    ALL_APPROVED_LIST_BY_HOUSE_NO(5, 0x0C),
    DATE_LIST(5, 0x0D),
    HOST_ALL_INFO(5, 0x0E),
    DELETE_RESERVATION(5, 0x0F),
    HOST_ALL_INFO_APPROVED(5,0x10);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private ReservationRequest(int type, int value) {
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
