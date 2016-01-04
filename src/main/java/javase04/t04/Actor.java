package javase04.t04;

public class Actor implements java.io.Serializable {
    private String name;
    private String dateOfBirth;
    private int rating;

    public Actor(String name, String dateOfBirth, int rating) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.rating = rating;
    }

    public Actor(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", rating=" + rating +
                '}';
    }
}
