package dataLayer.dataMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Mapper<T, I> {
    abstract protected T convertResultSetToDomainModel(ResultSet rs) throws SQLException;

    public abstract void init(List<T> data);
}
