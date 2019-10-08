package com.example.testhf.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testhf.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Programs {
    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("programimage")
    @Expose
    private String imageUrl;

    @SerializedName("channel")
    @Expose
    private Data chanel;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Data getChanel() {
        return chanel;
    }

    public void setChanel(Data chanel) {
        this.chanel = chanel;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", chanel=" + chanel +
                '}';
    }

    @BindingAdapter({ "imageUrl" })
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .into(imageView);
    }
}
