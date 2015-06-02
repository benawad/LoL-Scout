package benawad.com.lolscout.models.match_history;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benawad on 5/14/15.
 */
public class Games {
    private List<Game> games = new ArrayList<Game>();

    /**
     *
     * @return
     * The games
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     *
     * @param games
     * The games
     */
    public void setGames(List<Game> games) {
        this.games = games;
    }

}
