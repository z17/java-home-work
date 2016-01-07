package javase10.t02;

import javase10.t02.connectpool.ConnectionPool;
import javase10.t02.connectpool.ConnectionPoolException;

import java.sql.Connection;

public class DatabaseWorker {
    private Connection connection;

    public DatabaseWorker() {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.takeConnection();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

}
