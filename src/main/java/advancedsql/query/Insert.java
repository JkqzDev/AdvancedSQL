package advancedsql.query;

import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Insert extends ExecuteUpdate<Insert> {

    private final List<String> fields = new ArrayList<>();

    private final List<Object> values = new ArrayList<>();

    public Insert(ITable table) {
        super(table);
    }

    public Insert(ITable table, Map<String, Object> fields) {
        super(table);

        this.setFields(fields);
    }

    public Insert setField(String field, Object value) {
        this.fields.add(field);

        this.values.add(value);

        this.execute.add(value);

        return this;
    }

    public Insert field(String field, Object value) {
        return this.setField(field, value);
    }

    public Insert setFields(Map<String, Object> values) {
        for (Map.Entry<String, Object> entry: values.entrySet()) this.setField(entry.getKey(), entry.getValue());

        return this;
    }

    public Insert fields(Map<String, Object> values) {
        return this.setFields(values);
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("INSERT INTO " + this.table + " (");

        for (int i = 0; i < this.fields.size(); i++) query.append(i != this.fields.size() - 1 ? this.fields.get(i) + ", " : this.fields.get(i));

        query.append(") VALUES (");

        for (int i = 0; i < this.values.size(); i++) query.append(i != this.values.size() - 1 ? "?, " : "?");

        query.append(")");

        return query.toString();
    }
}
