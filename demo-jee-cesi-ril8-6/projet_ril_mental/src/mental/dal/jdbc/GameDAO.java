package mental.dal.jdbc;

import mental.bo.Game;
import mental.bo.Utilisateur;
import mental.dal.DAOFactory;
import mental.dal.IGameDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class GameDAO implements IGameDAO {

    private static final String CREATE_GAME = "INSERT INTO game (game_score, game_level, game_difficulte) VALUES(?,?,?)";
    private static final String UPDATE_GAME = "UPDATE game SET game_score=?, game_level=?, game_difficulte";
    private static final String DELETE_GAME = "DELETE FROM game WHERE game_id= ?";
    private static final String FIND_ALL_GAME = "SELECT * FROM game";
    private static final String FIND_BEST_SCORE = "SELECT * FROM game, utilisateur where game.utilisateur_id=utilisateur.utilisateur_id order by game.game_score DESC limit 10";
    private static final String FIND_BY_ID_GAME = "SELECT * FROM game WHERE game_id= ?";


    @Override
    public Collection<Game> findBestScore() {
        Collection<Game> ListeDesParties= new ArrayList<>();
        System.out.println("est-ce que tu va là?");
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_BEST_SCORE);
            ResultSet res=ps.executeQuery();
            while(res.next()) {
                System.out.println(res.getInt("game_score"));
                Utilisateur utisateur = new Utilisateur(res.getInt("utilisateur_id"),res.getString("utilisateur_email"),res.getString("utilisateur_nom"),res.getString("utilisateur_password"),res.getInt(("utilisateur_scoreMax")));
                ListeDesParties.add(new Game(res.getInt("game_id"),res.getInt("game_score"),res.getInt("game_level"),utisateur.getId(),res.getInt("game_difficulte")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListeDesParties;
    }

    @Override
    public void create(Game game) throws SQLException {
        Connection connection = DAOFactory.getJDBCConnection();
        if ( null != connection ) {
            try ( PreparedStatement ps = connection.prepareStatement(CREATE_GAME, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setInt( 1, game.getScore() );
                ps.setInt( 2, game.getLevel() );
                ps.setInt( 3, game.getDifficulte() );
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
    public void update(Game game) throws SQLException {

        try (Connection connection = DAOFactory.getJDBCConnection()) {
            if (null != connection) {
                try (PreparedStatement ps = connection.prepareStatement(UPDATE_GAME)) {
                    ps.setInt(1, game.getScore());
                    ps.setInt(2, game.getLevel());
                    ps.setInt( 3, game.getDifficulte() );
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
            PreparedStatement ps=connection.prepareStatement(DELETE_GAME);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Game game) throws SQLException {
        deleteById(game.getId());
    }

    @Override
    public Game findById(Integer id) {
        Game game = null;
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_BY_ID_GAME);
            ps.setInt(1,id);
            ResultSet res=ps.executeQuery();
            if(res.first()){
                game = new Game();
                game.setId(res.getInt(1));
                game.setScore(res.getInt(2));
                game.setLevel(res.getInt(3));
                game.setDifficulte(res.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }

    @Override
    public Collection<Game> findAll() {
        Collection<Game> ListeDesParties= new ArrayList<>();
        try (Connection connection = DAOFactory.getJDBCConnection()){
            PreparedStatement ps= connection.prepareStatement(FIND_ALL_GAME);
            ResultSet res=ps.executeQuery();
            while(res.next()) {
                Utilisateur utisateur = new Utilisateur(res.getInt("utilisateur_id"),res.getString("utilisateur_email"),res.getString("utilisateur_nom"),res.getString("utilisateur_password"),res.getInt(("utilisateur_scoreMax")));
                ListeDesParties.add(new Game(res.getInt("game_id"),res.getInt("game_score"),res.getInt("game_level"),utisateur.getId(),res.getInt("game_difficulte")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListeDesParties;
    }
}
