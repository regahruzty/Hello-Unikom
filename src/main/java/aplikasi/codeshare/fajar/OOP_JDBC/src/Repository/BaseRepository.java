package Repository;
import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T,E> {

    public T save(T value) throws SQLException;

    public T update(T value) throws SQLException;

    public List<T> findAll() throws SQLException;

    public Boolean exists(E id) throws SQLException;

    public void delete(E id) throws SQLException;

}
