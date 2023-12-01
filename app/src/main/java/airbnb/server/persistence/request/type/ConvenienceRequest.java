package airbnb.server.persistence.request.type;

public enum ConvenienceRequest implements RequestType {
    SELECT_CONVENIENCE(1, 0x01),
    INSERT_HOUSE_CONVE(1, 0x02),
    MAX_HOUSE_CONVE(1, 0x03),
    INSERT_ACCESS_CONVE(1, 0x04),
    MAX_ACCESS(1, 0x05),
    INSERT_BASIC_CONVE(1, 0x06),
    MAX_BASIC(1, 0x07),
    INSERT_MANY_SEARCH_CONVE(1, 0x08),
    MAX_MANY_SEARCH(1, 0x09),
    INSERT_SAFETY_CONVE(1, 0x0A),
    MAX_SAFETY(1, 0x0B);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private ConvenienceRequest(int type, int value) {
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
