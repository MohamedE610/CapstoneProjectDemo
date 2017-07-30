
package com.example.e610.capstoneproject.Models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Attributes implements Parcelable
{

    public String createdAt;
    public String updatedAt;
    public String slug;
    public String synopsis;
    public Integer coverImageTopOffset;
    public Titles titles;
    public String canonicalTitle;
    public List<String> abbreviatedTitles = null;
    public String averageRating;
    public RatingFrequencies ratingFrequencies;
    public Integer userCount;
    public Integer favoritesCount;
    public String startDate;
    public String endDate;
    public Integer popularityRank;
    public Integer ratingRank;
    public String ageRating;
    public String ageRatingGuide;
    public String subtype;
    public String status;
    public Object tba;
    public PosterImage posterImage;
    public CoverImage coverImage;
    public Integer episodeCount;
    public Integer episodeLength;
    public String youtubeVideoId;
    public String showType;
    public Boolean nsfw;
    public final static Creator<Attributes> CREATOR = new Creator<Attributes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes createFromParcel(Parcel in) {
            Attributes instance = new Attributes();
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.slug = ((String) in.readValue((String.class.getClassLoader())));
            instance.synopsis = ((String) in.readValue((String.class.getClassLoader())));
            instance.coverImageTopOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.titles = ((Titles) in.readValue((Titles.class.getClassLoader())));
            instance.canonicalTitle = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.abbreviatedTitles, (String.class.getClassLoader()));
            instance.averageRating = ((String) in.readValue((String.class.getClassLoader())));
            instance.ratingFrequencies = ((RatingFrequencies) in.readValue((RatingFrequencies.class.getClassLoader())));
            instance.userCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.favoritesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.startDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.endDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.popularityRank = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.ratingRank = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.ageRating = ((String) in.readValue((String.class.getClassLoader())));
            instance.ageRatingGuide = ((String) in.readValue((String.class.getClassLoader())));
            instance.subtype = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.tba = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.posterImage = ((PosterImage) in.readValue((PosterImage.class.getClassLoader())));
            instance.coverImage = ((CoverImage) in.readValue((CoverImage.class.getClassLoader())));
            instance.episodeCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.episodeLength = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.youtubeVideoId = ((String) in.readValue((String.class.getClassLoader())));
            instance.showType = ((String) in.readValue((String.class.getClassLoader())));
            instance.nsfw = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public Attributes[] newArray(int size) {
            return (new Attributes[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(slug);
        dest.writeValue(synopsis);
        dest.writeValue(coverImageTopOffset);
        dest.writeValue(titles);
        dest.writeValue(canonicalTitle);
        dest.writeList(abbreviatedTitles);
        dest.writeValue(averageRating);
        dest.writeValue(ratingFrequencies);
        dest.writeValue(userCount);
        dest.writeValue(favoritesCount);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(popularityRank);
        dest.writeValue(ratingRank);
        dest.writeValue(ageRating);
        dest.writeValue(ageRatingGuide);
        dest.writeValue(subtype);
        dest.writeValue(status);
        dest.writeValue(tba);
        dest.writeValue(posterImage);
        dest.writeValue(coverImage);
        dest.writeValue(episodeCount);
        dest.writeValue(episodeLength);
        dest.writeValue(youtubeVideoId);
        dest.writeValue(showType);
        dest.writeValue(nsfw);
    }

    public int describeContents() {
        return  0;
    }

}
