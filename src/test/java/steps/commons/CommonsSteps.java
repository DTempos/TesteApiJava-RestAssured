package steps.commons;

import io.cucumber.java.pt.Entao;
import util.PropertiesUtil;
import util.RequestManager;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;

public class CommonsSteps {
    protected PropertiesUtil propertiesUtil;

    public CommonsSteps() throws IOException {
        propertiesUtil = new PropertiesUtil();
    }

    @Entao("deve retornar o status code de {int}")
    public void deveRetornarOStatusCodeDe(int statusCode) {
        RequestManager.shared().getResponse().then().statusCode(statusCode);
    }

    @Entao("validar mensagem {string}")
    public void validarMensagem(String mensagem) {
        RequestManager.shared().getResponse().then().body(containsString(mensagem));
    }

    @Entao("valido o retorno dos dados de acordo com o contrato {string}")
    public void validoRetornoDosDadosDeAcordoComContrato(String pathSchema) {
        RequestManager.shared().getResponse().then()
                .body(matchesJsonSchemaInClasspath(pathSchema));
    }
}
