package airbnb.server.persistence.request.type;

public enum HouseRequest implements RequestType {
    SELECT_APPROVED_ALL_BY_HOST(3, 0x01),
    SELECT_APPROVED_ALL_BY_FILTER(3, 0x02),
    SELECT_APPROVED_ALL(3, 0x03),
    SELECT_HOUSE_DTO(3, 0x04),
    SELECT_UNAPPROVED_ALL(3, 0x05),
    APPROVED_HOUSE(3, 0x06),
    INSERT_HOUSE(3, 0x07),
    INSERT_HOUSE_WITH_INDIVIDUAL_ROOM(3, 0x08),
    MAX_HOUSE_NO(3, 0x09),
    SELECT_ALL_ORDER_BY_PAYMENT_ASC(3, 0x0A), // 0x0A == 10
    SELECT_ALL_ORDER_BY_PAYMENT_DESC(3, 0x0B),
    ALL_PAYMENT(3, 0x0C),
    ALL_DISCOUNT_INFO(3, 0x0D);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private HouseRequest(int type, int value) {
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
