package airbnb.server.persistence.request.type;

public enum PaymentRequest implements RequestType {
    SELECT_PAYMENT(4, 0x01),
    INSERT_PAYMENT(4, 0x02),
    SELECT_PAYMENT_BY_RESERVATION_NO(4, 0x03);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private PaymentRequest(int type, int value) {
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
