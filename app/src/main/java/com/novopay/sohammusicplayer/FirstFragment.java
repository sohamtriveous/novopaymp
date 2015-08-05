package com.novopay.sohammusicplayer;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.novopay.sohammusicplayer.models.Music;
import com.novopay.sohammusicplayer.provider.MusicSQLiteOpenHelper;
import com.novopay.sohammusicplayer.services.MusicService;

import java.util.ArrayList;
import java.util.List;

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

        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://img3.wikia.nocookie.net/__cb20150419065353/creepypasta/images/d/d3/Guns-N-Roses-Logo12312.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://acdcbrasilstore.com.br/image/cache/data/adesivos/adesivos-padrao/guns-n-roses/adesivo-guns-n-roses-classico-700x700.jpg"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "https://upload.wikimedia.org/wikipedia/en/9/9a/Guns_N_Roses_logo.png"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://logonoid.com/images/guns-n-roses-logo.jpg"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://images.artwanted.com/large/55/46044_781355.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb_ccw/sample_images/DSCF3300.JPG"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF3352_2.jpg"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF1773.JPG"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://img3.wikia.nocookie.net/__cb20150419065353/creepypasta/images/d/d3/Guns-N-Roses-Logo.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://acdcbrasilstore.com.br/image/cache/data/adesivos/adesivos-padrao/guns-n-roses/adesivo-guns-n-roses-classico-700x700.jpg"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "https://upload.wikimedia.org/wikipedia/en/9/9a/Guns_N_Roses_logo.png"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://logonoid.com/images/guns-n-roses-logo.jpg"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://images.artwanted.com/large/55/46044_781355.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb_ccw/sample_images/DSCF3300.JPG"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF3352_2.jpg"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF1773.JPG"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://img3.wikia.nocookie.net/__cb20150419065353/creepypasta/images/d/d3/Guns-N-Roses-Logo.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://acdcbrasilstore.com.br/image/cache/data/adesivos/adesivos-padrao/guns-n-roses/adesivo-guns-n-roses-classico-700x700.jpg"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "https://upload.wikimedia.org/wikipedia/en/9/9a/Guns_N_Roses_logo.png"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://logonoid.com/images/guns-n-roses-logo.jpg"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://images.artwanted.com/large/55/46044_781355.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb_ccw/sample_images/DSCF3300.JPG"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF3352_2.jpg"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF1773.JPG"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://img3.wikia.nocookie.net/__cb20150419065353/creepypasta/images/d/d3/Guns-N-Roses-Logo.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://acdcbrasilstore.com.br/image/cache/data/adesivos/adesivos-padrao/guns-n-roses/adesivo-guns-n-roses-classico-700x700.jpg"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "https://upload.wikimedia.org/wikipedia/en/9/9a/Guns_N_Roses_logo.png"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://logonoid.com/images/guns-n-roses-logo.jpg"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "http://images.artwanted.com/large/55/46044_781355.jpg"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb_ccw/sample_images/DSCF3300.JPG"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF3352_2.jpg"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "http://www.finepix-x100.com/en/sites/default/files/imagecache/sample_thumb/sample_images/DSCF1773.JPG"));


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_first_listview);
        musicAdapter = new MusicAdapter(getActivity(), musicList);
        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicService.startPlaying(getActivity());
            }
        });

        MusicSQLiteOpenHelper musicSQLiteOpenHelper = new MusicSQLiteOpenHelper(getActivity());
        SQLiteDatabase sqLiteDatabase = musicSQLiteOpenHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicSQLiteOpenHelper.Tables.MUSIC, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                String artistUrl = cursor.getString(cursor.getColumnIndex(MusicSQLiteOpenHelper.TableMusic.ARTIST_IMAGE_URL));
            } while (cursor.moveToNext());
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MusicSQLiteOpenHelper.TableMusic.ARTIST_IMAGE_URL, "My Album");

        sqLiteDatabase.update(MusicSQLiteOpenHelper.Tables.MUSIC, contentValues, MusicSQLiteOpenHelper.TableMusic.SONG + " = ?", new String[]{"hello"});
        sqLiteDatabase.insert(MusicSQLiteOpenHelper.Tables.MUSIC, null, contentValues);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
