package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class Timestamp extends Column {

    protected java.lang.String defaultValue;

    public Timestamp(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false);
    }

    public Timestamp defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " TIMESTAMP" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
