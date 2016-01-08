package javase13.t02;

public class Food {
    private int id;
    private String name;
    private String price;
    private String description;
    private int calories;

    public Food(int id, String name, String price, String description, int calories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }


    @Override
    public String toString() {
        return "Food {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                "}\n";
    }
}
