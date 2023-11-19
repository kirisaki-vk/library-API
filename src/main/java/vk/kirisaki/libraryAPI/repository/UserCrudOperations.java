package vk.kirisaki.libraryAPI.repository;

import vk.kirisaki.libraryAPI.models.Sex;
import vk.kirisaki.libraryAPI.models.User;
import vk.kirisaki.libraryAPI.utils.QueryTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserCrudOperations implements CrudOperations<User> {
    private final QueryTemplate QT = new QueryTemplate();

    @Override
    public User findById(Integer id) {
        return QT.executeSingleQuery(
                "SELECT * FROM " + '"' + "user"+ '"' + " WHERE id=?",
                ps -> {
                    ps.setInt( 1 ,id);
                },
                this::mapUser
        );
    }

    @Override
    public List<User> findAll() {
        return QT.executeQuery(
                "SELECT * FROM " + '"' + "user"+ '"',
                this::mapUser
        );
    }

    @Override
    public List<User> saveAll(List<User> toSave) {
        Integer userCount = toSave.size();
        for (User user:
             toSave) {
            if (
                    isNotSaved(user)
            ) {
                return null;
            }
        }

        return getLast(userCount);
    }

    private boolean isNotSaved(User user) {
        return QT.executeUpdate(
                "INSERT INTO " + '"' + "user"+ '"' + " (name, sex) VALUES " +
                        "(?,?)",
                ps -> {
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getSex().toString());
                }
        ) == 0;
    }

    @Override
    public User save(User toSave) {
        if (isNotSaved(toSave)) return null;
        return getLast(1).get(0);
    }

    @Override
    public User delete(User toDelete) {
        if(
                QT.executeUpdate(
                        "DELETE FROM " + '"' + "user" + '"' + " WHERE id=?",
                        ps -> {
                            ps.setInt(1, toDelete.getId());
                        }
                ) == 0
        ) {
            return null;
        }
        return toDelete;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        return new User(
            rs.getInt("id"),
                rs.getString("name"),
                Sex.valueOf(rs.getString("sex"))
        );
    }

    private List<User> getLast(Integer count) {
        return QT.executeQuery(
                "SELECT * FROM " + '"' + "user"+ '"' + " ORDER BY id DESC LIMIT " + count,
                this::mapUser
        );
    }
}
