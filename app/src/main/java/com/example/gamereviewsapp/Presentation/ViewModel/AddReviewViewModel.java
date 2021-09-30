package com.example.gamereviewsapp.Presentation.ViewModel;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.Repository;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AddReviewViewModel extends AndroidViewModel {

    public AddReviewViewModel(@NonNull Application application) {
        super(application);
    }

    public void addReview(String gameTitle, String reviewText, int score) {

        String newTitle = gameTitle.replaceAll("[\\s, :]", "");

        try {
            downloadImage(gameTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ContextWrapper wrapper = new ContextWrapper(getApplication().getApplicationContext());
        File file = wrapper.getDir("Images", ContextWrapper.MODE_PRIVATE);
        file = new File(file, newTitle +".jpg");
        String imgUri = Uri.fromFile(new File(String.valueOf(Uri.parse(file.getAbsolutePath())))).toString();
        Review review = new Review(gameTitle, reviewText, score, imgUri);

        Repository.getRepository().addReview(review);
    }

    public void deleteReview(String gameTitle, String reviewText, int score, String imgUri) {
        Review review = new Review(gameTitle, reviewText, score, imgUri);

        Repository.getRepository().deleteReview(review);
    }

    public void downloadImage(String gameTitle) throws IOException {
        try {
            String newTitle = gameTitle.replaceAll("[\\s, :]", "");
            String urlString = String.format("https://storage.yandexcloud.net/learning-bucket/GameReviewsAppImages/%s.jpg", newTitle);

            new DownloadTask(newTitle).execute(urlString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class DownloadTask extends AsyncTask<String, Void, Bitmap> {

        String title;

        public DownloadTask(String title) {
            this.title = title;
        }

        protected Bitmap doInBackground(String... urlString) {

            try {
                java.net.URL url = new java.net.URL(urlString[0]);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);

                input.close();
                return myBitmap;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                saveImageToInternalStorage(result, title);
            }
        }
    }

    Uri saveImageToInternalStorage(Bitmap bitmap, String title) {

        ContextWrapper wrapper = new ContextWrapper(getApplication().getApplicationContext());
        File file = wrapper.getDir("Images", ContextWrapper.MODE_PRIVATE);
        file = new File(file, title +".jpg");
        try{
            OutputStream stream = null;
            stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            stream.flush();
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri savedImageURI = Uri.parse(file.getAbsolutePath());
        return savedImageURI;
    }
}
