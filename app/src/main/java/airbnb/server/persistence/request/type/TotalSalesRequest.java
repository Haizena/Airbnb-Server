package airbnb.server.persistence.request.type;

public enum TotalSalesRequest implements RequestType {
    INSERT_TOTAL_AMOUNT(8, 0x01),
    DROP_TOTAL_AMOUNT(8, 0x02),
    ALL_TOTAL_SALES_BY_HOUSE_NO(8, 0x03);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private TotalSalesRequest(int type, int value) {
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

