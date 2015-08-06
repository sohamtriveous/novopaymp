package com.novopay.sohammusicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.novopay.sohammusicplayer.models.Collection1;
import com.novopay.sohammusicplayer.models.Music;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by sohammondal on 04/08/15.
 */
public class MusicAdapter extends BaseAdapter {
    WeakReference<Context> contextWeakReference;
    List<Collection1> musicList;

    public MusicAdapter(Context context, List<Collection1> musicList) {
        this.contextWeakReference = new WeakReference<Context>(context);
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Collection1 getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView artistImageView;
        TextView albumTextView;
        TextView songTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(contextWeakReference.get());
            view = layoutInflater.inflate(R.layout.item_music, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.albumTextView = (TextView) view.findViewById(R.id.item_music_album);
            viewHolder.artistImageView = (ImageView) view.findViewById(R.id.item_music_artist);
            viewHolder.songTextView = (TextView) view.findViewById(R.id.item_music_song);

            view.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (ViewHolder) view.getTag();
        }

        Collection1 collection1 = getItem(position);

        viewHolder.albumTextView.setText(collection1.getArtistname().getText());
        Picasso
                .with(contextWeakReference.get())
                .load(collection1.getArtistimage().getSrc())
                .error(R.drawable.ic_launcher)
                .into(viewHolder.artistImageView);
        viewHolder.songTextView.setText(collection1.getSongname().getText());

        return view;
    }
}
