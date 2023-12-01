package airbnb.server.persistence.request.type;

public enum ReviewRequest implements RequestType {
    INSERT_REVIEW(6, 0x01),
    INSERT_RE_REVIEW(6, 0x02),
    REVIEW(6, 0x03),
    RE_REVIEW(6, 0x04),
    HOUSE_REVIEW(6, 0x05),
    WRITE_REVIEW_LIST(6, 0x06);

    private final int type; // 요청 타입을 구분하기 위한 변수입니다.
    private final int value;

    private ReviewRequest(int type, int value) {
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
