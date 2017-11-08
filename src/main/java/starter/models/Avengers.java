package starter.models;

import java.util.List;

/**
 * Created by ashishpundalik on 08/11/2017.
 */
public class Avengers {
    private List<Avenger> avengers;

    public Avengers() {}

    public void setAvengers(List<Avenger> avengers) { this.avengers = avengers; }

    public List<Avenger> getAvengers() {
        return avengers;
    }
}
