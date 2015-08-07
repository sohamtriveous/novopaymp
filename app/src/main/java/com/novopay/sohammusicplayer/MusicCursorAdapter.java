package com.novopay.sohammusicplayer;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.novopay.sohammusicplayer.provider.MusicSQLiteOpenHelper;
import com.squareup.picasso.Picasso;

/**
 * Created by sohammondal on 06/08/15.
 */
public class MusicCursorAdapter extends CursorAdapter {
    public MusicCursorAdapter(Context context, Cursor c) {
        super(context, c, false);
    }


    private class ViewHolder {
        ImageView artistImageView;
        TextView albumTextView;
        TextView songTextView;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_music, parent, false);

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.albumTextView = (TextView) view.findViewById(R.id.item_music_album);
        viewHolder.artistImageView = (ImageView) view.findViewById(R.id.item_music_artist);
        viewHolder.songTextView = (TextView) view.findViewById(R.id.item_music_song);

        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        String imageUrl =cursor.getString(cursor.getColumnIndex(MusicSQLiteOpenHelper.TableMusic.ARTIST_IMAGE_URL));
        String song =cursor.getString(cursor.getColumnIndex(MusicSQLiteOpenHelper.TableMusic.SONG));
        String album =cursor.getString(cursor.getColumnIndex(MusicSQLiteOpenHelper.TableMusic.ALBUM));

        viewHolder.albumTextView.setText(album);
        Picasso
                .with(context)
                .load(imageUrl)
                .error(R.drawable.ic_launcher)
                .into(viewHolder.artistImageView);
        viewHolder.songTextView.setText(song);
    }
}
