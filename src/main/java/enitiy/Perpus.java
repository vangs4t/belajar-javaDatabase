package enitiy;

public class Perpus {
    private int id;
    private String email;
    private String title;
    private String content;

    public Perpus(int id, String email, String title, String content) {
        this.id = id;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public Perpus(String email, String title, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public Perpus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
