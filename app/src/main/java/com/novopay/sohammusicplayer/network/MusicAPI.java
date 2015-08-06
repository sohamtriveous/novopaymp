package com.novopay.sohammusicplayer.network;

import com.novopay.sohammusicplayer.models.MusicApiResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by sohammondal on 06/08/15.
 */
public class MusicAPI {
    private static final String URL = "https://www.kimonolabs.com/api";
    private static MusicInterface musicInterface = null;

    public static MusicInterface getApi() {
        if(musicInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(URL)
                    .build();
            musicInterface = restAdapter.create(MusicInterface.class);
        }
        return musicInterface;
    }

    public interface MusicInterface {
        @GET("/af05zsru?apikey=ZdSnJCoFzxb1gjUS3m9wSx97NrSPDbdQ")
        MusicApiResponse getMusicList();

        @GET("/af05zsru?apikey=ZdSnJCoFzxb1gjUS3m9wSx97NrSPDbdQ")
        void getMusicList(Callback<MusicApiResponse> musicApiResponseCallback);
    }
}
