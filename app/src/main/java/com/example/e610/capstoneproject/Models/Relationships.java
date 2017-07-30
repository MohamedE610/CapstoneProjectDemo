
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Relationships implements Parcelable
{

    public Genres genres;
    public Categories categories;
    public Castings castings;
    public Installments installments;
    public Mappings mappings;
    public Reviews reviews;
    public MediaRelationships mediaRelationships;
    public Episodes episodes;
    public StreamingLinks streamingLinks;
    public AnimeProductions animeProductions;
    public AnimeCharacters animeCharacters;
    public AnimeStaff animeStaff;
    public final static Creator<Relationships> CREATOR = new Creator<Relationships>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Relationships createFromParcel(Parcel in) {
            Relationships instance = new Relationships();
            instance.genres = ((Genres) in.readValue((Genres.class.getClassLoader())));
            instance.categories = ((Categories) in.readValue((Categories.class.getClassLoader())));
            instance.castings = ((Castings) in.readValue((Castings.class.getClassLoader())));
            instance.installments = ((Installments) in.readValue((Installments.class.getClassLoader())));
            instance.mappings = ((Mappings) in.readValue((Mappings.class.getClassLoader())));
            instance.reviews = ((Reviews) in.readValue((Reviews.class.getClassLoader())));
            instance.mediaRelationships = ((MediaRelationships) in.readValue((MediaRelationships.class.getClassLoader())));
            instance.episodes = ((Episodes) in.readValue((Episodes.class.getClassLoader())));
            instance.streamingLinks = ((StreamingLinks) in.readValue((StreamingLinks.class.getClassLoader())));
            instance.animeProductions = ((AnimeProductions) in.readValue((AnimeProductions.class.getClassLoader())));
            instance.animeCharacters = ((AnimeCharacters) in.readValue((AnimeCharacters.class.getClassLoader())));
            instance.animeStaff = ((AnimeStaff) in.readValue((AnimeStaff.class.getClassLoader())));
            return instance;
        }

        public Relationships[] newArray(int size) {
            return (new Relationships[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(genres);
        dest.writeValue(categories);
        dest.writeValue(castings);
        dest.writeValue(installments);
        dest.writeValue(mappings);
        dest.writeValue(reviews);
        dest.writeValue(mediaRelationships);
        dest.writeValue(episodes);
        dest.writeValue(streamingLinks);
        dest.writeValue(animeProductions);
        dest.writeValue(animeCharacters);
        dest.writeValue(animeStaff);
    }

    public int describeContents() {
        return  0;
    }

}
