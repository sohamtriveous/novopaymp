package com.novopay.sohammusicplayer.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;


/**
 * Created by sohammondal on 07/08/15.
 */
public class MusicProvider extends ContentProvider {


    public static final String AUTHORITY_FREE = "com.novopay.sohammusicplayer.provider.musicprovider";

    public static final String AUTHORITY = AUTHORITY_FREE;

    public static final Uri RECORDER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + MusicSQLiteOpenHelper.Tables.MUSIC);

    public static final Uri RECORDER_FREE_CONTENT_URI = Uri.parse("content://" + AUTHORITY_FREE + "/" + MusicSQLiteOpenHelper.Tables.MUSIC);

    private MusicSQLiteOpenHelper mRecorderDatabase;

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mRecorderDatabase.getWritableDatabase();
        int count = 0;

        switch (sUriMatcher.match(uri)) {
            case MUSIC:
                count = db.delete(MusicSQLiteOpenHelper.Tables.MUSIC, selection,
                        selectionArgs);
                break;
            case MUSIC_ID:
                count = db.delete(MusicSQLiteOpenHelper.Tables.MUSIC, selection,
                        selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return count;
    }

    @Override
    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);
        switch (match) {
            case MUSIC:
                return "vnd.android.cursor.dir/vnd.novopay.MUSIC";
            case MUSIC_ID:
                return "vnd.android.cursor.item/vnd.novopay.MUSIC";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        String table = new String();
        SQLiteDatabase db = mRecorderDatabase.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case MUSIC:
                table = MusicSQLiteOpenHelper.Tables.MUSIC;
                break;
            case MUSIC_ID:
                table = MusicSQLiteOpenHelper.Tables.MUSIC;
                break;
        }

        long row = db.insert(table, null, values);
        if (row > 0) {
            Uri newUri = null;
            newUri = ContentUris.withAppendedId(RECORDER_CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(newUri, null);
            return (newUri);
        } else
            return null;
    }

    @Override
    public boolean onCreate() {
        mRecorderDatabase = new MusicSQLiteOpenHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = mRecorderDatabase.getReadableDatabase();

        switch (sUriMatcher.match(uri)) {
            case MUSIC:
                qb.setTables(MusicSQLiteOpenHelper.Tables.MUSIC);
                break;
            case MUSIC_ID:
                qb.setTables(MusicSQLiteOpenHelper.Tables.MUSIC);
                break;
        }

        try {
            Cursor c = qb.query(db, projection, selection, selectionArgs, null,
                    null, sortOrder);

            c.setNotificationUri(getContext().getContentResolver(), uri);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        int count = 0;
        String table = new String();
        SQLiteDatabase db = mRecorderDatabase.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case MUSIC:
                count = db.update(MusicSQLiteOpenHelper.Tables.MUSIC, values, selection,
                        selectionArgs);
                break;
            case MUSIC_ID:
                count = db.update(
                        MusicSQLiteOpenHelper.Tables.MUSIC,
                        values,
                        "_ID = "
                                + uri.getPathSegments().get(1)
                                + (!TextUtils.isEmpty(selection) ? " AND ("
                                + selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return count;
    }

    // UriMatcher values for the tables and table _IDs for my app
    // currently using just one table, the audio table
    // might increase in the future
    private static final int MUSIC = 100;
    private static final int MUSIC_ID = 101;

    public static UriMatcher sUriMatcher = buildUriMatcher();


    public static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        matcher.addURI(AUTHORITY, "music", MUSIC);
        matcher.addURI(AUTHORITY, "music/*", MUSIC_ID);
        return matcher;
    }

}

