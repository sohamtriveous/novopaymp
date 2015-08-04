package com.novopay.sohammusicplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.novopay.sohammusicplayer.models.Music;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

/**
 * Created by sohammondal on 04/08/15.
 */
public class FirstFragment extends Fragment {
    private ListView listView;

    private List<Music> musicList = new ArrayList<>();
    private MusicAdapter musicAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_first_listview);
        musicAdapter = new MusicAdapter(getActivity(), musicList);
        listView.setAdapter(musicAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
