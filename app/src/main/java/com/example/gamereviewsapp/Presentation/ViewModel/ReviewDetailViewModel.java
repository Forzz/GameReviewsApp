package com.example.gamereviewsapp.Presentation.ViewModel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import androidx.lifecycle.ViewModel;

import java.io.FileNotFoundException;

public class ReviewDetailViewModel extends ViewModel {

    public Bitmap getImage(Activity parent, String uri) throws FileNotFoundException {
        return BitmapFactory.decodeFileDescriptor(parent.getApplicationContext().getContentResolver().openFileDescriptor(Uri.parse(uri), "r").getFileDescriptor());
    }
}
