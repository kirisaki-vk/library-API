package vk.kirisaki.libraryAPI.repository;

import vk.kirisaki.libraryAPI.models.Book;
import vk.kirisaki.libraryAPI.utils.QueryTemplate;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookCrudOperations implements CrudOperations<Book> {
    private final QueryTemplate QT = new QueryTemplate();

    @Override
    public Book findById(Integer id) {
        return QT.executeSingleQuery(
                "SELECT *  FROM book WHERE id=?",
                ps -> {
                    ps.setInt(1, id);
                },
                this::mapBook
        );
    }

    @Override
    public List<Book> findAll() {
        return QT.executeQuery(
                "SELECT * FROM book;",
                this::mapBook
        );
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        for (Book book :
                toSave) {
            if (executeSave(book)) return null;
        }
        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        if (executeSave(toSave)) return null;
        return toSave;
    }

    private boolean executeSave(Book toSave) {
        return QT.executeUpdate(
                "INSERT INTO book ( " +
                        "title," +
                        "topic," +
                        "author_id," +
                        "page ) " +
                        "VALUES (?,?,?,?)",
                ps -> {
                    ps.setString(1, toSave.getTitle());
                    ps.setString(2, toSave.getTopic().toString());
                    ps.setString(3, toSave.getAuthor().getId().toString());
                    ps.setInt(4, toSave.getPage());
                }
        ) == 0;
    }

    @Override
    public Book delete(Book toDelete) {
        if (
                QT.executeUpdate(
                        "DELETE FROM book WHERE id=?",
                        ps -> {
                            ps.setString(1, toDelete.getId().toString());
                        }
                ) == 0
        ) {
            return null;
        }
        return  toDelete;
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        return new Book(
                UUID.fromString(rs.getString("id")),
                rs.getString("title"),
                rs.getInt("page"),
                rs.getDate("release_date"),
                //TODO: get proper relations
                null,
                null,
                rs.getBoolean("available")
        );
    }

}
