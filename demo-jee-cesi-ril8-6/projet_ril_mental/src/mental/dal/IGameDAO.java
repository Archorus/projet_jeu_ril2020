package mental.dal;

import mental.bo.Game;

import java.sql.SQLException;
import java.util.Collection;

public interface IGameDAO extends IDAO<Integer , Game> {
    Collection<Game> findBestScore();

    @Override
    void create(Game object) throws SQLException;
}
