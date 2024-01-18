package service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.PropertiesUtil;
import util.RequestManager;

import static io.restassured.RestAssured.given;

public class BaseService {
    protected PropertiesUtil propertiesUtil;

    public Response doGetRequestWithoutParameters(String resource) {
        return given().log().all()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .when()
                .get(resource);
    }

    public Response doPostRequestJson(String payloadJson, String resource) {
        return given()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .body(payloadJson)
                .when()
                .post(resource);
    }

    public Response doPatchRequestJson(String payloadJson, String resource) {
        return given()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .body(payloadJson)
                .when()
                .patch(resource);
    }
}
