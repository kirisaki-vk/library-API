package vk.kirisaki.libraryAPI.repository;

import vk.kirisaki.libraryAPI.models.Author;
import vk.kirisaki.libraryAPI.models.User;
import vk.kirisaki.libraryAPI.utils.QueryTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {
    private final QueryTemplate QT = new QueryTemplate();
    private final UserCrudOperations userRepo = new UserCrudOperations();

    @Override
    public Author findById(Integer id) {
        return QT.executeSingleQuery(
                "SELECT * FROM author WHERE id=?",
                ps -> {
                    ps.setInt(1, id);
                },
                this::mapAuthor
        );
    }

    @Override
    public List<Author> findAll() {
        return QT.executeQuery(
                "SELECT * FROM author",
                this::mapAuthor
        );
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        for (Author author:
             toSave) {
            if(isNotSaved(author)) {
                return null;
            }
        }
        return getLast(toSave.size());
    }

    @Override
    public Author save(Author toSave) {
        if (isNotSaved(toSave)){
            return null;
        }
        return getLast(1).get(0);
    }

    @Override
    public Author delete(Author toDelete) {
        if (
                QT.executeUpdate(
                        "DELETE FROM author WHERE id=?",
                        ps -> {
                            ps.setInt(1, toDelete.getId());
                        }
                ) == 0
        ) {
            return null;
        }
        return toDelete;
    }

    private Author mapAuthor(ResultSet rs) throws SQLException {
        Integer userId = rs.getInt("user_id");
        User authorUser = userRepo.findById(userId);
        return new Author(
                authorUser.getName(),
                authorUser.getReference(),
                authorUser.getSex(),
                rs.getInt("id")
        );
    }

    private boolean isNotSaved(Author toSave) {
        Integer userId = userRepo.save(new User(
                toSave.getName(),
                toSave.getSex()
        )).getId();
        return QT.executeUpdate(
                "INSERT INTO author (user_id, reference) " +
                        "VALUES (?,?)",
                ps -> {
                    ps.setInt(1, userId);
                    ps.setString(2, toSave.getReference());
                }
        ) == 0;
    }

    private List<Author> getLast(Integer count) {
        return QT.executeQuery(
                "SELECT * FROM author ORDER BY id DESC LIMIT " + count,
                this::mapAuthor
        );
    }
}
