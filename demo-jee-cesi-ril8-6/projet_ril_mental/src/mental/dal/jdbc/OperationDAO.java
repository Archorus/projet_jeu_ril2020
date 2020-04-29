package mental.dal.jdbc;

import mental.bo.Operation;
import mental.dal.IOperationDAO;

import java.sql.SQLException;
import java.util.Collection;

public class OperationDAO implements IOperationDAO {

    private static final String CREATE_OPERATION = "INSERT INTO operation (expression_data, expression_reponseCalcul, expression_reponseUser) VALUES(?,?,?)";
    private static final String UPDATE_OPERATION = "UPDATE operation SET expression_data=?, expression_reponseCalcul=?, expression_reponseUser=?where expression_id=?";
    private static final String DELETE_OPERATION = "DELETE FROM operation WHERE operation_id= ?";
    private static final String FIND_BY_ID_OPERATION = "SELECT * FROM operation WHERE operation_id= ?";
    private static final String FIND_ALL_OPERATION = "SELECT * FROM operation";

    @Override
    public void create(Operation object) throws SQLException {

    }

    @Override
    public void update(Operation object) throws SQLException {

    }

    @Override
    public void deleteById(Integer integer) throws SQLException {

    }

    @Override
    public void delete(Operation object) throws SQLException {

    }

    @Override
    public Operation findById(Integer integer) {

        return null;
    }

    @Override
    public Collection<Operation> findAll() {

        return null;
    }
}
