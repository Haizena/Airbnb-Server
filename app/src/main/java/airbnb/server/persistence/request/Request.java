package airbnb.server.persistence.request;

import java.io.Serializable;

import airbnb.depricated.persistence.request.type.RequestType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request implements Serializable {
    private RequestType type;
    private Object requestObject = null;

    public Request(RequestType type) {
        this.type = type;
    }

    public Request(RequestType type, Object requestObject) {
        this.type = type;
        this.requestObject = requestObject;
    }
}
