package javase10.t02;

import javase10.t02.connectpool.ConnectionPool;
import javase10.t02.connectpool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
    private static final String TABLE_NAME = "book";
    private Connection connection;

    public BookDAO() {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            pool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        try {
            connection = pool.takeConnection();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    // todo: parameter превратить в ENUM, чтобы не могли присылать левые строки
    public ArrayList<Book> get(String parameter, Object value) {
        String select = "SELECT id, name, author, count_reads FROM " + TABLE_NAME + " WHERE " + parameter + " = ?";
        ArrayList<Book> result = null;
        try ( PreparedStatement ps = connection.prepareStatement(
                select,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            )
        ){
            if (value instanceof String) {
                ps.setString(1, (String) value);
            } else if (value instanceof  Integer) {
                ps.setInt(1, (Integer) value);
            } else {
                System.out.println("something went wrong with type of the value");
                throw new SQLException("wrong type of value in SELECT");
            }
            result = getList(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Book> get() {
        String select = "SELECT id, name, author, count_reads FROM " + TABLE_NAME;
        ArrayList<Book> result = null;
        try ( PreparedStatement ps = connection.prepareStatement(
                select,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        )
        ){
            result = getList(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    private ArrayList<Book> getList(PreparedStatement ps) {
        ArrayList<Book> result = new ArrayList<>();
        try  (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int countReads = rs.getInt("count_reads");
                result.add(new Book(id, name, author, countReads));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void create(Book book) {
        String insert = "INSERT INTO " + TABLE_NAME + " (name, author, count_reads) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(insert)){
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCountReads());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void update(Book book) {
        String update = "UPDATE " + TABLE_NAME + " SET name = ?, author = ?, count_reads = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCountReads());
            ps.setInt(4, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(Book book) {
        String delete = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(delete)){
            ps.setInt(1, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
