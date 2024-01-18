package service;

import io.restassured.response.Response;
import org.json.JSONObject;
import util.PropertiesUtil;
import util.RequestManager;

import java.io.IOException;

public class AplicacaoService extends BaseService {
    private static final String BASE_URI = "renner.baseURI";
    private static final String API_USERS_ENDPOINT = "/api/users";
    private static final String SLASH = "/";
    private static final String PARAMETER_PAGE_TWO_ENDPOINT = "?page=2";

    public AplicacaoService() throws IOException {
        propertiesUtil = new PropertiesUtil();
        RequestManager.shared().setBaseURI(propertiesUtil.getProperty(BASE_URI));
    }

    public Response createUser(String name, String job) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        String payload = jsonObject.toString();

        return doPostRequestJson(payload, API_USERS_ENDPOINT);
    }

    public Response getUserCreated(String idUser) {
        return doGetRequestWithoutParameters(API_USERS_ENDPOINT + SLASH + idUser);
    }

    public Response getUser(String id) {
        return doGetRequestWithoutParameters(API_USERS_ENDPOINT + SLASH + id);
    }

    public Response getListUsers() {
        return doGetRequestWithoutParameters(API_USERS_ENDPOINT + PARAMETER_PAGE_TWO_ENDPOINT);
    }

    public Response updateUser(String updateName, String updateJob, String idUser) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", updateName);
        jsonObject.put("job", updateJob);

        String payload = jsonObject.toString();

        return doPatchRequestJson(payload, API_USERS_ENDPOINT + SLASH + idUser);
    }
}
