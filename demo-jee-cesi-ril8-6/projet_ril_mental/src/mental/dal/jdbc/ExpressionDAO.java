package mental.dal.jdbc;

import mental.bo.Expression;
import mental.dal.DAOFactory;
import mental.dal.IExpressionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ExpressionDAO  implements IExpressionDAO {

    private static final String CREATE_EXPRESSION = "INSERT INTO expression (expression_data, expression_reponseCalcul, expression_reponseUser) VALUES(?,?,?)";
    private static final String UPDATE_EXPRESSION = "UPDATE expression SET expression_data=?, expression_reponseCalcul=?, expression_reponseUser=?where expression_id=?";
    private static final String DELETE_EXPRESSION = "DELETE FROM expression WHERE expression_id= ?";
    private static final String FIND_BY_ID_EXPRESSION = "SELECT * FROM expression WHERE expression_id= ?";
    private static final String FIND_ALL_EXPRESSION = "SELECT * FROM expression";

    @Override
    public void create(Expression expression) throws SQLException {
        Connection connection = DAOFactory.getJDBCConnection();
        if ( null != connection ) {
            try ( PreparedStatement ps = connection.prepareStatement(CREATE_EXPRESSION, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setString( 1, expression.getFullData() );
                ps.setInt( 2, expression.getExpectedValue() );
                ps.setInt( 3, expression.getProvidedValue() );
                ps.executeUpdate();
                try ( ResultSet rs = ps.getGeneratedKeys() ) {
                    if ( rs.next()) {
                        expression.setId( rs.getInt( 1 ) );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Expression expression) throws SQLException {

        try (Connection connection = DAOFactory.getJDBCConnection()) {
            if (null != connection) {
                try (PreparedStatement ps = connection.prepareStatement(UPDATE_EXPRESSION)) {
                    ps.setString( 1, expression.getFullData() );
                    ps.setInt( 2, expression.getExpectedValue() );
                    ps.setInt( 3, expression.getProvidedValue() );
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        try(Connection connection=DAOFactory.getJDBCConnection()){
            PreparedStatement ps=connection.prepareStatement(DELETE_EXPRESSION);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Expression expression) throws SQLException {
        deleteById(expression.getId());
    }

    @Override
    public Expression findById(Integer id) {
        Expression expression = null;
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_BY_ID_EXPRESSION);
            ps.setInt(1,id);
            ResultSet res=ps.executeQuery();
            if(res.first()){
                expression = new Expression();
                expression.setId(res.getInt(1));
                expression.FullDataToData(res.getString(2));
                expression.setExpectedValue(res.getInt(3));
                expression.setProvidedValue(res.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expression;
    }

    @Override
    public Collection<Expression> findAll() {
        Collection<Expression> listeDesExpressions= new ArrayList<>();
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_ALL_EXPRESSION);
            ResultSet res=ps.executeQuery();
            while(res.next()) {
                listeDesExpressions.add(new Expression(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeDesExpressions;

    }

}
