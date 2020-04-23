package mental.dal.jdbc;

import mental.bo.Game;
import mental.dal.DAOFactory;
import mental.dal.IGameDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class GameDAO implements IGameDAO {

    private static final String CREATE_GAME = "INSERT INTO utilisateur (score, level) VALUES(?,?)";
    private static final String UPDATE_GAME = "UPDATE utilisateur SET name=?, email=?, password=?, ScoreMax=? where id=?";
    private static final String DELETE_GAME = "DELETE FROM utilisateur WHERE id= ?";
    private static final String FIND_ALL_GAME = "SELECT * FROM utilisateur";
    private static final String FIND_BY_ID_GAME = "SELECT * FROM utilisateur WHERE id= ?";


    @Override
    public void create(Game game) throws SQLException {
        Connection connection = DAOFactory.getJDBCConnection();
        if ( null != connection ) {
            try ( PreparedStatement ps = connection.prepareStatement(CREATE_GAME, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setString( 1, game.get() );
                ps.setString( 2, game.get() );
                ps.executeUpdate();
                try ( ResultSet rs = ps.getGeneratedKeys() ) {
                    if ( rs.next()) {
                        game.setId( rs.getInt( 1 ) );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Utilisateur utilisateur) throws SQLException {

        try (Connection connection = DAOFactory.getJDBCConnection()) {
            if (null != connection) {
                try (PreparedStatement ps = connection.prepareStatement(UPDATE_UTILISATEUR)) {
                    ps.setString(1, utilisateur.getName());
                    ps.setString(2, utilisateur.getEmail());
                    ps.setString(3, utilisateur.getPassword());
                    ps.setInt(4, utilisateur.getScore_max());
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
            PreparedStatement ps=connection.prepareStatement(DELETE_UTILISATEUR);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Utilisateur utilisateur) throws SQLException{
        deleteById(utilisateur.getId());
    }

    @Override
    public Utilisateur findById(Integer id) {
        Utilisateur utilisateur =new Utilisateur();
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_BY_ID_UTILISATEUR);
            ps.setInt(1,id);
            ResultSet res=ps.executeQuery();
            if(res.first()){
                utilisateur.setId(res.getInt(1));
                utilisateur.setName(res.getString(2));
                utilisateur.setEmail(res.getString(3));
                utilisateur.setPassword(res.getString(4));
                utilisateur.setScore_max(res.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public Collection<Utilisateur> findAll() {
        Collection<Utilisateur> ListeUtilisateurs= new ArrayList<>();
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_ALL_UTILISATEUR);
            ResultSet res=ps.executeQuery();
            while(res.next()) {
                ListeUtilisateurs.add(new Utilisateur(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListeUtilisateurs;
    }
}
