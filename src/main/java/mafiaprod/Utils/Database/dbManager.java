package mafiaprod.Utils.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getLogger;

public class dbManager {
    private final String dbPath;

    private Connection connection;

    public dbManager(String pluginFolderPath) {
        this.dbPath = pluginFolderPath + File.separator + "database.db";
    }


    // Подключение к базе данных
    public void connect() {
        try {
            // Создаем файл базы данных, если его нет
            File dbFile = new File(dbPath);
            if (!dbFile.exists()) {
                dbFile.getParentFile().mkdirs();
                dbFile.createNewFile();
            }

            // Устанавливаем соединение с SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            System.out.println("Соединение с базой данных установлено.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Создаем таблицы, если они не существуют
    public void createTables() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS States (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "desc TEXT" +
                "ruler_uuid TEXT NOT NULL," +
                "treasury INTEGER DEFAULT 0" +
                "military_force INTEGER DEFAULT 0" +
                "polit_system TEXT" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
            System.out.println("Таблицы успешно созданы или уже существуют.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Закрываем соединение
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                getLogger().log(Level.INFO, "Statehood database enabled!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
