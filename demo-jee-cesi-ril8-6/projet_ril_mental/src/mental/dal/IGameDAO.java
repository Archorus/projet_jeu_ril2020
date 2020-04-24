package mental.dal;

import mental.bo.Game;

import java.util.Collection;

public interface IGameDAO extends IDAO<Integer , Game> {
    Collection<Game> findBestScore();

}
