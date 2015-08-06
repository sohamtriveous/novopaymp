package com.novopay.sohammusicplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.novopay.sohammusicplayer.models.MusicApiResponse;
import com.novopay.sohammusicplayer.network.MusicAPI;
import com.novopay.sohammusicplayer.services.MusicService;

import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sohammondal on 04/08/15.
 */
public class FirstFragment extends Fragment {
    private ListView listView;
    private MusicAdapter musicAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_first_listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicService.startPlaying(getActivity());
            }
        });

        MusicAPI.getApi().getMusicList(new Callback<MusicApiResponse>() {
            @Override
            @DebugLog
            public void success(MusicApiResponse musicApiResponse, Response response) {
                musicAdapter = new MusicAdapter(getActivity(), musicApiResponse.getResults().getCollection1());
                listView.setAdapter(musicAdapter);
                Toast.makeText(getActivity(), "Number of entries: "+musicApiResponse.getResults().getCollection1().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            @DebugLog
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), "Some error "+error.getResponse().getReason(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
