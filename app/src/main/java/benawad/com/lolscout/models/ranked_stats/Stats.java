package benawad.com.lolscout.models.ranked_stats;

import java.io.Serializable;

/**
 * Created by benawad on 5/14/15.
 */
public class Stats implements Serializable {

    private int totalSessionsPlayed;
    private int totalSessionsLost;
    private int totalSessionsWon;
    private int totalChampionKills;
    private int killingSpree;
    private int totalDamageDealt;
    private int totalDamageTaken;
    private int mostChampionKillsPerSession;
    private int totalMinionKills;
    private int totalDoubleKills;
    private int totalTripleKills;
    private int totalQuadraKills;
    private int totalPentaKills;
    private int totalUnrealKills;
    private int totalDeathsPerSession;
    private int totalGoldEarned;
    private int mostSpellsCast;
    private int totalTurretsKilled;
    private int totalPhysicalDamageDealt;
    private int totalMagicDamageDealt;
    private int totalNeutralMinionsKilled;
    private int totalFirstBlood;
    private int totalAssists;
    private int totalHeal;
    private int maxLargestKillingSpree;
    private int maxLargestCriticalStrike;
    private int maxChampionsKilled;
    private int maxNumDeaths;
    private int maxTimePlayed;
    private int maxTimeSpentLiving;
    private int normalGamesPlayed;
    private int rankedSoloGamesPlayed;
    private int rankedPremadeGamesPlayed;
    private int botGamesPlayed;

    /**
     *
     * @return
     * The totalSessionsPlayed
     */
    public int getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    /**
     *
     * @param totalSessionsPlayed
     * The totalSessionsPlayed
     */
    public void setTotalSessionsPlayed(int totalSessionsPlayed) {
        this.totalSessionsPlayed = totalSessionsPlayed;
    }

    /**
     *
     * @return
     * The totalSessionsLost
     */
    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    /**
     *
     * @param totalSessionsLost
     * The totalSessionsLost
     */
    public void setTotalSessionsLost(int totalSessionsLost) {
        this.totalSessionsLost = totalSessionsLost;
    }

    /**
     *
     * @return
     * The totalSessionsWon
     */
    public int getTotalSessionsWon() {
        return totalSessionsWon;
    }

    /**
     *
     * @param totalSessionsWon
     * The totalSessionsWon
     */
    public void setTotalSessionsWon(int totalSessionsWon) {
        this.totalSessionsWon = totalSessionsWon;
    }

    /**
     *
     * @return
     * The totalChampionKills
     */
    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    /**
     *
     * @param totalChampionKills
     * The totalChampionKills
     */
    public void setTotalChampionKills(int totalChampionKills) {
        this.totalChampionKills = totalChampionKills;
    }

    /**
     *
     * @return
     * The killingSpree
     */
    public int getKillingSpree() {
        return killingSpree;
    }

    /**
     *
     * @param killingSpree
     * The killingSpree
     */
    public void setKillingSpree(int killingSpree) {
        this.killingSpree = killingSpree;
    }

    /**
     *
     * @return
     * The totalDamageDealt
     */
    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    /**
     *
     * @param totalDamageDealt
     * The totalDamageDealt
     */
    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    /**
     *
     * @return
     * The totalDamageTaken
     */
    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    /**
     *
     * @param totalDamageTaken
     * The totalDamageTaken
     */
    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    /**
     *
     * @return
     * The mostChampionKillsPerSession
     */
    public int getMostChampionKillsPerSession() {
        return mostChampionKillsPerSession;
    }

    /**
     *
     * @param mostChampionKillsPerSession
     * The mostChampionKillsPerSession
     */
    public void setMostChampionKillsPerSession(int mostChampionKillsPerSession) {
        this.mostChampionKillsPerSession = mostChampionKillsPerSession;
    }

    /**
     *
     * @return
     * The totalMinionKills
     */
    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    /**
     *
     * @param totalMinionKills
     * The totalMinionKills
     */
    public void setTotalMinionKills(int totalMinionKills) {
        this.totalMinionKills = totalMinionKills;
    }

    /**
     *
     * @return
     * The totalDoubleKills
     */
    public int getTotalDoubleKills() {
        return totalDoubleKills;
    }

    /**
     *
     * @param totalDoubleKills
     * The totalDoubleKills
     */
    public void setTotalDoubleKills(int totalDoubleKills) {
        this.totalDoubleKills = totalDoubleKills;
    }

    /**
     *
     * @return
     * The totalTripleKills
     */
    public int getTotalTripleKills() {
        return totalTripleKills;
    }

    /**
     *
     * @param totalTripleKills
     * The totalTripleKills
     */
    public void setTotalTripleKills(int totalTripleKills) {
        this.totalTripleKills = totalTripleKills;
    }

    /**
     *
     * @return
     * The totalQuadraKills
     */
    public int getTotalQuadraKills() {
        return totalQuadraKills;
    }

    /**
     *
     * @param totalQuadraKills
     * The totalQuadraKills
     */
    public void setTotalQuadraKills(int totalQuadraKills) {
        this.totalQuadraKills = totalQuadraKills;
    }

    /**
     *
     * @return
     * The totalPentaKills
     */
    public int getTotalPentaKills() {
        return totalPentaKills;
    }

    /**
     *
     * @param totalPentaKills
     * The totalPentaKills
     */
    public void setTotalPentaKills(int totalPentaKills) {
        this.totalPentaKills = totalPentaKills;
    }

    /**
     *
     * @return
     * The totalUnrealKills
     */
    public int getTotalUnrealKills() {
        return totalUnrealKills;
    }

    /**
     *
     * @param totalUnrealKills
     * The totalUnrealKills
     */
    public void setTotalUnrealKills(int totalUnrealKills) {
        this.totalUnrealKills = totalUnrealKills;
    }

    /**
     *
     * @return
     * The totalDeathsPerSession
     */
    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    /**
     *
     * @param totalDeathsPerSession
     * The totalDeathsPerSession
     */
    public void setTotalDeathsPerSession(int totalDeathsPerSession) {
        this.totalDeathsPerSession = totalDeathsPerSession;
    }

    /**
     *
     * @return
     * The totalGoldEarned
     */
    public int getTotalGoldEarned() {
        return totalGoldEarned;
    }

    /**
     *
     * @param totalGoldEarned
     * The totalGoldEarned
     */
    public void setTotalGoldEarned(int totalGoldEarned) {
        this.totalGoldEarned = totalGoldEarned;
    }

    /**
     *
     * @return
     * The mostSpellsCast
     */
    public int getMostSpellsCast() {
        return mostSpellsCast;
    }

    /**
     *
     * @param mostSpellsCast
     * The mostSpellsCast
     */
    public void setMostSpellsCast(int mostSpellsCast) {
        this.mostSpellsCast = mostSpellsCast;
    }

    /**
     *
     * @return
     * The totalTurretsKilled
     */
    public int getTotalTurretsKilled() {
        return totalTurretsKilled;
    }

    /**
     *
     * @param totalTurretsKilled
     * The totalTurretsKilled
     */
    public void setTotalTurretsKilled(int totalTurretsKilled) {
        this.totalTurretsKilled = totalTurretsKilled;
    }

    /**
     *
     * @return
     * The totalPhysicalDamageDealt
     */
    public int getTotalPhysicalDamageDealt() {
        return totalPhysicalDamageDealt;
    }

    /**
     *
     * @param totalPhysicalDamageDealt
     * The totalPhysicalDamageDealt
     */
    public void setTotalPhysicalDamageDealt(int totalPhysicalDamageDealt) {
        this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
    }

    /**
     *
     * @return
     * The totalMagicDamageDealt
     */
    public int getTotalMagicDamageDealt() {
        return totalMagicDamageDealt;
    }

    /**
     *
     * @param totalMagicDamageDealt
     * The totalMagicDamageDealt
     */
    public void setTotalMagicDamageDealt(int totalMagicDamageDealt) {
        this.totalMagicDamageDealt = totalMagicDamageDealt;
    }

    /**
     *
     * @return
     * The totalNeutralMinionsKilled
     */
    public int getTotalNeutralMinionsKilled() {
        return totalNeutralMinionsKilled;
    }

    /**
     *
     * @param totalNeutralMinionsKilled
     * The totalNeutralMinionsKilled
     */
    public void setTotalNeutralMinionsKilled(int totalNeutralMinionsKilled) {
        this.totalNeutralMinionsKilled = totalNeutralMinionsKilled;
    }

    /**
     *
     * @return
     * The totalFirstBlood
     */
    public int getTotalFirstBlood() {
        return totalFirstBlood;
    }

    /**
     *
     * @param totalFirstBlood
     * The totalFirstBlood
     */
    public void setTotalFirstBlood(int totalFirstBlood) {
        this.totalFirstBlood = totalFirstBlood;
    }

    /**
     *
     * @return
     * The totalAssists
     */
    public int getTotalAssists() {
        return totalAssists;
    }

    /**
     *
     * @param totalAssists
     * The totalAssists
     */
    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    /**
     *
     * @return
     * The totalHeal
     */
    public int getTotalHeal() {
        return totalHeal;
    }

    /**
     *
     * @param totalHeal
     * The totalHeal
     */
    public void setTotalHeal(int totalHeal) {
        this.totalHeal = totalHeal;
    }

    /**
     *
     * @return
     * The maxLargestKillingSpree
     */
    public int getMaxLargestKillingSpree() {
        return maxLargestKillingSpree;
    }

    /**
     *
     * @param maxLargestKillingSpree
     * The maxLargestKillingSpree
     */
    public void setMaxLargestKillingSpree(int maxLargestKillingSpree) {
        this.maxLargestKillingSpree = maxLargestKillingSpree;
    }

    /**
     *
     * @return
     * The maxLargestCriticalStrike
     */
    public int getMaxLargestCriticalStrike() {
        return maxLargestCriticalStrike;
    }

    /**
     *
     * @param maxLargestCriticalStrike
     * The maxLargestCriticalStrike
     */
    public void setMaxLargestCriticalStrike(int maxLargestCriticalStrike) {
        this.maxLargestCriticalStrike = maxLargestCriticalStrike;
    }

    /**
     *
     * @return
     * The maxChampionsKilled
     */
    public int getMaxChampionsKilled() {
        return maxChampionsKilled;
    }

    /**
     *
     * @param maxChampionsKilled
     * The maxChampionsKilled
     */
    public void setMaxChampionsKilled(int maxChampionsKilled) {
        this.maxChampionsKilled = maxChampionsKilled;
    }

    /**
     *
     * @return
     * The maxNumDeaths
     */
    public int getMaxNumDeaths() {
        return maxNumDeaths;
    }

    /**
     *
     * @param maxNumDeaths
     * The maxNumDeaths
     */
    public void setMaxNumDeaths(int maxNumDeaths) {
        this.maxNumDeaths = maxNumDeaths;
    }

    /**
     *
     * @return
     * The maxTimePlayed
     */
    public int getMaxTimePlayed() {
        return maxTimePlayed;
    }

    /**
     *
     * @param maxTimePlayed
     * The maxTimePlayed
     */
    public void setMaxTimePlayed(int maxTimePlayed) {
        this.maxTimePlayed = maxTimePlayed;
    }

    /**
     *
     * @return
     * The maxTimeSpentLiving
     */
    public int getMaxTimeSpentLiving() {
        return maxTimeSpentLiving;
    }

    /**
     *
     * @param maxTimeSpentLiving
     * The maxTimeSpentLiving
     */
    public void setMaxTimeSpentLiving(int maxTimeSpentLiving) {
        this.maxTimeSpentLiving = maxTimeSpentLiving;
    }

    /**
     *
     * @return
     * The normalGamesPlayed
     */
    public int getNormalGamesPlayed() {
        return normalGamesPlayed;
    }

    /**
     *
     * @param normalGamesPlayed
     * The normalGamesPlayed
     */
    public void setNormalGamesPlayed(int normalGamesPlayed) {
        this.normalGamesPlayed = normalGamesPlayed;
    }

    /**
     *
     * @return
     * The rankedSoloGamesPlayed
     */
    public int getRankedSoloGamesPlayed() {
        return rankedSoloGamesPlayed;
    }

    /**
     *
     * @param rankedSoloGamesPlayed
     * The rankedSoloGamesPlayed
     */
    public void setRankedSoloGamesPlayed(int rankedSoloGamesPlayed) {
        this.rankedSoloGamesPlayed = rankedSoloGamesPlayed;
    }

    /**
     *
     * @return
     * The rankedPremadeGamesPlayed
     */
    public int getRankedPremadeGamesPlayed() {
        return rankedPremadeGamesPlayed;
    }

    /**
     *
     * @param rankedPremadeGamesPlayed
     * The rankedPremadeGamesPlayed
     */
    public void setRankedPremadeGamesPlayed(int rankedPremadeGamesPlayed) {
        this.rankedPremadeGamesPlayed = rankedPremadeGamesPlayed;
    }

    /**
     *
     * @return
     * The botGamesPlayed
     */
    public int getBotGamesPlayed() {
        return botGamesPlayed;
    }

    /**
     *
     * @param botGamesPlayed
     * The botGamesPlayed
     */
    public void setBotGamesPlayed(int botGamesPlayed) {
        this.botGamesPlayed = botGamesPlayed;
    }

}