package javase10.t01;

class Test {
    private int id;
    private String name;
    private double lat;
    private double lon;

    public Test(int id, String name, double lat, double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                "}\n";
    }
}
