package repository;

import Utility.ConnectionUtil;
import enitiy.Perpus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerpusRepositoryImpl implements PerpusRepostiroy{
    @Override
    public void save(Perpus perpus) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String update = """
                    INSERT INTO perpus (id_mahasiswa,email, title, content) VALUES (?,?,?,?);
                    """;
            try (PreparedStatement statement = connection.prepareStatement(update,Statement.RETURN_GENERATED_KEYS)){
                statement.setInt(1, perpus.getId());
                statement.setString(2, perpus.getEmail());
                statement.setString(3, perpus.getTitle());
                statement.setString(4, perpus.getContent());
                statement.executeUpdate();
                try (ResultSet set = statement.getGeneratedKeys()){
                    if (set.next()){
                        perpus.setId(set.getInt(1));
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Perpus searchByTitle(String title) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String search = "SELECT * FROM perpus WHERE title = ?";
            try (PreparedStatement statement = connection.prepareStatement(search)){
                statement.setString(1, title);
                try (ResultSet set = statement.executeQuery()){
                    if (set.next()){
                        return new Perpus(
                                set.getString("email"),
                                set.getString("title"),
                                set.getString("content")
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Perpus> findAll() {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet set = statement.executeQuery("SELECT * FROM perpus")){
                    List<Perpus> perpuses = new ArrayList<>();
                    while (set.next()){
                        perpuses.add(new Perpus(
                                set.getInt("id_mahasiswa"),
                                set.getString("email"),
                                set.getString("title"),
                                set.getString("content")
                        ));
                    }
                    return perpuses;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Perpus> findAllByEmail(String email) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String update =  "SELECT * FROM perpus FROM email = ?";
            try (PreparedStatement statement = connection.prepareStatement(update)){
                statement.setString(1, email);
                try (ResultSet set = statement.executeQuery()){
                    List<Perpus> perpuses = new ArrayList<>();
                    while (set.next()){
                        perpuses.add(new Perpus(
                                set.getString("email"),
                                set.getString("title"),
                                set.getString("content")
                        ));
                    }
                    return perpuses;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
