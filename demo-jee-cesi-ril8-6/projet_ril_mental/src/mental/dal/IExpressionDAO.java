package mental.dal;

import mental.bo.Expression;

import java.sql.SQLException;

public interface IExpressionDAO  extends IDAO<Integer, Expression>{
    void create(Expression expression) throws SQLException;
}
