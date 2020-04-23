package mental.dal;

import java.sql.SQLException;
import java.util.Collection;

    public interface IDAO<ID, T> {

        void create(T object) throws SQLException;
        void update(T object) throws SQLException;
        void deleteById(ID id) throws SQLException;
        void delete(T object) throws SQLException;
        T findById(ID id);
        Collection<T> findAll();
    }

