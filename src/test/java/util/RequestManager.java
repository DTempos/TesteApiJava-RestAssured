package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class RequestManager {
    private static RequestManager sharedInstance;
    private RequestSpecification request;
    private Response response;
    private JSONObject helpJsonObject = null;

    public static RequestManager shared() {
        if (sharedInstance == null) {
            sharedInstance = new RequestManager();
        }
        return sharedInstance;
    }

    public RequestSpecification getRequest() {
        if (request == null) {
            request = new RequestSpecBuilder().build();
        }
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public JSONObject getHelpJsonObject() {
        return helpJsonObject;
    }

    public void setResponse(final Response response) {
        this.response = response;
    }

    public void setHelpJsonObject(final JSONObject helpJsonObject) {
        this.helpJsonObject = helpJsonObject;
    }

    public void setBaseURI(final String uri) {
        this.getRequest().baseUri(uri);
    }
}
