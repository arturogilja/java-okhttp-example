package mx.arturogil.httprequestexample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }
}