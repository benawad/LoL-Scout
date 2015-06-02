package benawad.com.lolscout.interfaces;

import benawad.com.lolscout.models.Summoner;
import benawad.com.lolscout.models.match_history.Games;
import benawad.com.lolscout.models.ranked_stats.Champions;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by benawad on 5/11/15.
 */
public interface Riot {

    @GET("/api/lol/{region}/v1.4/summoner/by-name/{summonerName}")
    void summoner(
            @Path("region") String region,
            @Path("summonerName") String summonerName,
            @Query("api_key") String apiKey,
            Callback<Summoner> cb
    );

    @GET("/api/lol/{region}/v1.3/game/by-summoner/{sumId}/recent")
    void matchHistory(
            @Path("region") String region,
            @Path("sumId") String sumId,
            @Query("api_key") String apiKey,
            Callback<Games> cb
    );

    @GET("/api/lol/{region}/v1.3/stats/by-summoner/{sumId}/ranked")
    void rankedStats(
            @Path("region") String region,
            @Path("sumId") String sumId,
            @Query("api_key") String apiKey,
            Callback<Champions> cb
    );

}
