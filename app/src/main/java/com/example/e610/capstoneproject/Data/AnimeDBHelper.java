/*
 * Copyright 2016.  Dmitry Malkovich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.e610.capstoneproject.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Manages a local database for movies data.
 */
public class AnimeDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AnimeManga.db";

    public AnimeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_FavouriteAnime_TABLE = "CREATE TABLE " + AnimeContract.FavouriteAnimeEntry.TABLE_NAME
                + " (" +
                AnimeContract.FavouriteAnimeEntry._ID + " INTEGER PRIMARY KEY ," +
                AnimeContract.FavouriteAnimeEntry.COLUMN_anime_ID + " INTEGER NOT NULL, " +
                AnimeContract.FavouriteAnimeEntry.COLUMN_anime_content + " TEXT NOT NULL " +
                " );";
        final String SQL_CREATE_FavouriteManga_TABLE = "CREATE TABLE " + AnimeContract.FavouriteMangaEntry.TABLE_NAME
                + " (" +
                AnimeContract.FavouriteMangaEntry._ID + " INTEGER PRIMARY KEY ," +
                AnimeContract.FavouriteMangaEntry.COLUMN_manga_ID + " INTEGER NOT NULL, " +
                AnimeContract.FavouriteMangaEntry.COLUMN_manga_content + " TEXT NOT NULL " +
                " );";
        sqLiteDatabase.execSQL(SQL_CREATE_FavouriteAnime_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_FavouriteManga_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AnimeContract.FavouriteAnimeEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AnimeContract.FavouriteMangaEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
