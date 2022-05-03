import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class Requisicao {
    private HttpClient client = HttpClient.newHttpClient();
    private BodyHandler<String> bodyHandler = BodyHandlers.ofString();

    public Requisicao() {
    }

    public HttpResponse request(String url) {
        try {
            return this.tryRequest(url);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    private HttpResponse tryRequest(String url) throws Exception {
        HttpRequest request = this.buildRequest(url);
        HttpResponse response = this.sendRequest(request);

        return response;
    }

    private HttpRequest buildRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("accept", "application/json")
                .build();
    }

    private HttpResponse sendRequest(HttpRequest request) throws Exception {
        return this.client.send(request, this.bodyHandler);
    }
}
