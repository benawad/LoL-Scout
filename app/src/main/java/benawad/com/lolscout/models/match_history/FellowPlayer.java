package benawad.com.lolscout.models.match_history;

public class FellowPlayer {

    private int summonerId;
    private int teamId;
    private int championId;

    /**
     *
     * @return
     * The summonerId
     */
    public int getSummonerId() {
        return summonerId;
    }

    /**
     *
     * @param summonerId
     * The summonerId
     */
    public void setSummonerId(int summonerId) {
        this.summonerId = summonerId;
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

}