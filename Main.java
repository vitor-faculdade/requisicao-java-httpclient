// https://www.twilio.com/blog/5-maneiras-de-fazer-uma-chamada-http-em-java

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

        Requisicao req = new Requisicao();

        HttpResponse response = req.request(url);

        System.out.println(response.body());
        System.out.println(response.statusCode());
    }
}
