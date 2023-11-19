package vk.kirisaki.libraryAPI.repository;

import vk.kirisaki.libraryAPI.models.Subsciber;
import vk.kirisaki.libraryAPI.models.User;
import vk.kirisaki.libraryAPI.utils.QueryTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subsciber> {
    private final UserCrudOperations userRepo = new UserCrudOperations();
    private final QueryTemplate QT = new QueryTemplate();

    @Override
    public Subsciber findById(Integer id) {
        return QT.executeSingleQuery(
                "SELECT * FROM subscriber WHERE id=?",
                ps -> {
                    ps.setInt(1, id);
                },
                this::mapSubscriber
        );
    }

    @Override
    public List<Subsciber> findAll() {
        return QT.executeQuery(
                "SELECT * FROM subscriber",
                this::mapSubscriber
        );
    }

    @Override
    public List<Subsciber> saveAll(List<Subsciber> toSave) {
        for (Subsciber subs:
             toSave) {
            if (isNotSaved(subs)) {
                return null;
            }
        }
        return getLast(toSave.size());
    }

    @Override
    public Subsciber save(Subsciber toSave) {
        if(isNotSaved(toSave)) {
            return null;
        }
        return getLast(1).get(0);
    }

    @Override
    public Subsciber delete(Subsciber toDelete) {
        if (
                QT.executeUpdate(
                        "DELETE FROM subscriber WHERE id=?",
                        ps -> {
                            ps.setInt(1, toDelete.getId());
                        }
                ) == 0
        ) {
            return null;
        }
        return toDelete;
    }

    private boolean isNotSaved(Subsciber toSave) {
        User insertedUser = userRepo.save(new User(
                toSave.getName(),
                toSave.getReference(),
                toSave.getSex()
        ));
        return QT.executeUpdate(
                "INSERT INTO subscriber (user_id, reference) " +
                        "VALUES (?,?)",
                ps -> {
                    ps.setInt(1, insertedUser.getId());
                    ps.setString(2, toSave.getReference());
                }
        ) == 0;
    }

    private Subsciber mapSubscriber(ResultSet rs) throws SQLException {
        User user = userRepo.findById(rs.getInt("user_id"));
        return new Subsciber(
                user.getName(),
                user.getReference(),
                user.getSex(),
                rs.getInt("id")
        );
    }

    private List<Subsciber> getLast(Integer count) {
        return QT.executeQuery(
                "SELECT * FROM subscriber ORDER BY id DESC LIMIT " + count,
                this::mapSubscriber
        );
    }
}
