/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advancedsql;

import advancedsql.query.Alter;
import advancedsql.query.Create;
import advancedsql.query.Insert;
import advancedsql.query.Update;
import advancedsql.query.action.Add;
import advancedsql.query.action.Drop;
import advancedsql.query.action.Modify;
import advancedsql.table.ITable;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class MySQLTest {
    public MySQL connect() throws SQLException {
        return new MySQL("127.0.0.1", 3306, "root", "", "unittesting");
    }

    @Test public void testConnection() {
        try {
            MySQL mySQL = connect();

            assertTrue(mySQL.isConnected());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testCreateTable() {
        try {
            MySQL mySQL = connect();

            ITable table = mySQL.table("test");

            if (mySQL.table("test").exists()) {
                System.out.println("Table test already exists, deleting.");

                table.drop().execute();
            }

            Create create = table.create();

            create.id();

            create.string("first_name");

            create.string("last_name");

            create.string("test");

            Boolean result = create.execute();

            System.out.println(create);

            System.out.println(result);

            assertFalse(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testAfterTable() {
        try {
            MySQL mySQL = connect();

            Alter alter = mySQL.table("test").alter();

            Add add = alter.add();

            add.string("token").nullable();
            add.string("connection_id").nullable();

            Drop drop = alter.drop();

            drop.column("test");

            Modify modify = alter.modify();

            modify.integer("connection_id").nullable();

            Boolean result = alter.execute();

            System.out.println(alter);

            System.out.println(result);

            assertFalse(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testInsert() {
        try {
            MySQL mySQL = connect();

            Insert query = mySQL.table("test").insert(new HashMap<>(){{
                put("first_name", "Denzel");
                put("last_name", "Code");
            }});

            int execute = query.execute();

            System.out.println(execute);

            assertEquals(1, execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testUpdate() {
        try {
            MySQL mySQL = connect();

            Update query = mySQL.table("test").update(new HashMap<>(){{
                put("token", "Advanced");
            }}).where("first_name = ?", "Denzel");

            System.out.println(query);

            int execute = query.execute();

            System.out.println(execute);

            assertEquals(1, execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
