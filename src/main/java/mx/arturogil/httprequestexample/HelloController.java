package mx.arturogil.httprequestexample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class HelloController {
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @FXML
    private ListView<String> listView;

    @FXML
    private void initialize() {
        fetchPosts();
    }

    private void fetchPosts() {
        new Thread(() -> {
            try {
                Request request = new Request.Builder()
                        .get()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                    String responseBody = response.body().string();
                    List<Post> posts = objectMapper.readValue(responseBody, new TypeReference<>() {
                    });

                    Platform.runLater(() -> {
                        for (Post post : posts) {
                            listView.getItems().add(post.getTitle());
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}