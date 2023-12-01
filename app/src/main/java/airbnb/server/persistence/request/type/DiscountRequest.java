package airbnb.server.persistence.request.type;

public enum DiscountRequest implements RequestType {
    SELECT_DISCOUNT(2, 0x01),
    INSERT_AMOUNT_DISCOUNT(2, 0x02),
    INSERT_RATE_DISCOUNT(2, 0x03);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private DiscountRequest(int type, int value) {
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
