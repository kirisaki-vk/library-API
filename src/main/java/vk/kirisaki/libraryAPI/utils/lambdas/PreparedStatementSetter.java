package vk.kirisaki.libraryAPI.utils.lambdas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter {
    void setStatement(PreparedStatement ps) throws SQLException;
}
