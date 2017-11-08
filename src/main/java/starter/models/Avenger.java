package starter.models;

/**
 * Created by ashishpundalik on 13/06/2017.
 */

public class Avenger {
    private String name;
    private long id;
    private String email;

    public Avenger() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
