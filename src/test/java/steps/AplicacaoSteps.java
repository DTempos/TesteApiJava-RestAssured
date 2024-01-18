package steps;

import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.json.JSONObject;
import service.AplicacaoService;
import util.RequestManager;

import java.io.IOException;

public class AplicacaoSteps {
    private static final String ID = "id";

    AplicacaoService aplicacaoService;

    public AplicacaoSteps() throws IOException {
        aplicacaoService = new AplicacaoService();
    }

    @Quando("criar usuario com nome {string} e trabalho {string}")
    public void criarUsuarioComNomeStrETrabalhoStr(String name, String job) {
        RequestManager.shared().setResponse(aplicacaoService.createUser(name, job));
        RequestManager.shared().getResponse().then().log().all();

        Response resp = RequestManager.shared().getResponse();
        String idUser = resp.then().extract().path(ID).toString();

        JSONObject idCreated = new JSONObject();
        idCreated.put(ID, idUser);
        RequestManager.shared().setHelpJsonObject(idCreated);
    }

    /**
     * Método criado para consultar o usuario que acabou de ser criado
     */
    @Quando("consultar o usuario criado")
    public void consultarUsuarioCriado() {
        String idUser = RequestManager.shared().getHelpJsonObject().get(ID).toString();

        RequestManager.shared().setResponse(aplicacaoService.getUserCreated(idUser));
        RequestManager.shared().getResponse().then().log().all();
    }

    @Quando("consultar um usuario do sistema com ID {string}")
    public void consultarUsuarioDoSistemaComIdStr(String id) {
        RequestManager.shared().setResponse(aplicacaoService.getUser(id));
        RequestManager.shared().getResponse().then().log().all();
    }

    @Quando("consultar lista de usuarios do sistema")
    public void consultarListaDeUsuariosDoSistema() {
        RequestManager.shared().setResponse(aplicacaoService.getListUsers());
        RequestManager.shared().getResponse().then().log().all();
    }

    @Quando("atualizar informacao de nome {string} e trabalho {string} para o usuario com ID {string}")
    public void atualizarInformacaoDeNomeStrETrabalhoStrParaUsuarioIdStr(String updateName, String updateJob,
                                                                         String idUser) {
        RequestManager.shared().setResponse(aplicacaoService.updateUser(updateName, updateJob, idUser));
        RequestManager.shared().getResponse().then().log().all();
    }
}
