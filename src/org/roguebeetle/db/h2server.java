// Классс проверки рабортоспособности сервера H2
package org.roguebeetle.db;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class h2server {

    private Connection c = null;
    private Statement stmt = null;

    String ConUrl = "jdbc:h2:tcp://localhost/~/kip";
    String User = "SA";
    String Pass = "";
    String args = "-tcp";

    public void start(){
        try {
            Server server = Server.createTcpServer(args).start();
            System.out.println("Сервер запущен");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Что-то пошло не так");
            System.exit(0);
        }

    };
    public void stop(){
        try {
            Server server = Server.createTcpServer(args);
            server.stop();
            System.out.println("Сервер остановлен");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Что-то пошло не так");
            System.exit(0);
        }
    };
    public void testH2conn(){
        try {
            Class.forName("org.h2.Driver");
            c = DriverManager.getConnection(ConUrl, User, Pass);
            stmt = c.createStatement();
            //stmt.executeUpdate("sql statement");
            System.out.println("Проверка подключения:");
            stmt.close();
            c.commit();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Что-то пошло не так");
            System.exit(0);
        }
        System.out.println("Всё Заебца");
    }

}
