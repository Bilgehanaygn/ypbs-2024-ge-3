package yte.ypbs.ypbs_2024_ge3.trigger;

import org.h2.api.Trigger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KatkiInsertTrigger implements Trigger {
    @Override
    public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type) throws SQLException {
        // Initialization code, if needed
    }

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO USER_KATKI (user_id, katki_id) VALUES (?, ?)");
        stmt.setLong(1, (Long) newRow[8]); // newRow[8] is user_id
        stmt.setLong(2, (Long) newRow[0]); // newRow[0] is id (katki_id)
        stmt.executeUpdate();
    }

    @Override
    public void close() throws SQLException {
        // Cleanup code, if needed
    }

    @Override
    public void remove() throws SQLException {
        // Removal code, if needed
    }
}
