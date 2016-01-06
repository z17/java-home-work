package javase10.t01;

import java.sql.*;
import java.util.ArrayList;

class DataBaseWorker {
    private static final String DATABASE_NAME = "test";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String TABLE_NAME = "`test`";
    private Connection connection;

    public DataBaseWorker() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("connect");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            Statement create = connection.createStatement();
            String s = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "  ( " +
                    " `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    " `name` VARCHAR(255) NOT NULL, " +
                    " `lat` FLOAT(10, 7) NOT NULL, " +
                    " `lon` FLOAT(10, 7) NOT NULL, " +
                    "PRIMARY KEY (`id`) " +
                    ") ENGINE=InnoDB  DEFAULT CHARSET=utf8; ";
            create.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        try {
            Statement create = connection.createStatement();
            String s = "DROP TABLE " + TABLE_NAME;
            create.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String newName, double newLat, double newLon) {
        String update = "UPDATE " + TABLE_NAME + " SET name = ?, lat = ?, lon = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, newName);
            ps.setDouble(2, newLat);
            ps.setDouble(3, newLon);
            ps.setInt(4, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void insert(String name, double lat, double lon) {

        String insert = "INSERT INTO " + TABLE_NAME + " (name, lat, lon) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, name);
            ps.setDouble(2, lat);
            ps.setDouble(3, lon);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Test> select(TestColumns key, Object value) {
        String select = "SELECT id, name, lat, lon FROM " + TABLE_NAME + " WHERE "+key+" = ?";
        ArrayList<Test> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    select,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            if (value instanceof String) {
                ps.setString(1, (String) value);
            } else if (value instanceof Double) {
                ps.setDouble(1, (Double) value);
            } else if (value instanceof  Integer) {
                ps.setInt(1, (Integer) value);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double lat = rs.getDouble("lat");
                double lon = rs.getDouble("lon");
                String name = rs.getString("name");
                result.add( new Test(id, name, lat, lon));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
