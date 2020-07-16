package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class Decimal extends Numeric {

    protected java.lang.Integer precision;

    public Decimal(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false, false, 5);

        this.precision = 2;
    }

    public Decimal(IAction<IColumn> action, java.lang.String name, java.lang.Integer length, java.lang.Integer precision) {
        super(action, name, false, false, length);

        this.precision = precision;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " DECIMAL(" + length + ", " + precision + ")" + (nullable ? " " : " NOT NULL ") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
