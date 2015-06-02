package benawad.com.lolscout.models.match_history;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int gameId;
    private boolean invalid;
    private String gameMode;
    private String gameType;
    private String subType;
    private int mapId;
    private int teamId;
    private int championId;
    private int spell1;
    private int spell2;
    private int level;
    private int ipEarned;
    private int createDate;
    private List<FellowPlayer> fellowPlayers = new ArrayList<FellowPlayer>();
    private GameStats stats;

    /**
     *
     * @return
     * The gameId
     */
    public int getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     * The gameId
     */
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return
     * The invalid
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     *
     * @param invalid
     * The invalid
     */
    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    /**
     *
     * @return
     * The gameMode
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     *
     * @param gameMode
     * The gameMode
     */
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    /**
     *
     * @return
     * The gameType
     */
    public String getGameType() {
        return gameType;
    }

    /**
     *
     * @param gameType
     * The gameType
     */
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    /**
     *
     * @return
     * The subType
     */
    public String getSubType() {
        return subType;
    }

    /**
     *
     * @param subType
     * The subType
     */
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     *
     * @return
     * The mapId
     */
    public int getMapId() {
        return mapId;
    }

    /**
     *
     * @param mapId
     * The mapId
     */
    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    /**
     *
     * @return
     * The teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     * The teamId
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     * The championId
     */
    public int getChampionId() {
        return championId;
    }

    /**
     *
     * @param championId
     * The championId
     */
    public void setChampionId(int championId) {
        this.championId = championId;
    }

    /**
     *
     * @return
     * The spell1
     */
    public int getSpell1() {
        return spell1;
    }

    /**
     *
     * @param spell1
     * The spell1
     */
    public void setSpell1(int spell1) {
        this.spell1 = spell1;
    }

    /**
     *
     * @return
     * The spell2
     */
    public int getSpell2() {
        return spell2;
    }

    /**
     *
     * @param spell2
     * The spell2
     */
    public void setSpell2(int spell2) {
        this.spell2 = spell2;
    }

    /**
     *
     * @return
     * The level
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param level
     * The level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     * @return
     * The ipEarned
     */
    public int getIpEarned() {
        return ipEarned;
    }

    /**
     *
     * @param ipEarned
     * The ipEarned
     */
    public void setIpEarned(int ipEarned) {
        this.ipEarned = ipEarned;
    }

    /**
     *
     * @return
     * The createDate
     */
    public int getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate
     * The createDate
     */
    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @return
     * The fellowPlayers
     */
    public List<FellowPlayer> getFellowPlayers() {
        return fellowPlayers;
    }

    /**
     *
     * @param fellowPlayers
     * The fellowPlayers
     */
    public void setFellowPlayers(List<FellowPlayer> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    /**
     *
     * @return
     * The stats
     */
    public GameStats getStats() {
        return stats;
    }

    /**
     *
     * @param championStats
     * The stats
     */
    public void setStats(GameStats championStats) {
        this.stats = championStats;
    }

}