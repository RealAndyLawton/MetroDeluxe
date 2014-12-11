package com.realandylawton.metrodeluxe.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by realandylawton on 12/11/14.
 */
public class JsonAssetsLoader {

    public static <T> T parseAsset(Context context, String fileName, Class<T> type) throws IOException {

        AssetManager assetManager = context.getAssets();

        InputStream in = assetManager.open(fileName);

        int size = in.available();
        byte[] buffer = new byte[size];

        in.read(buffer);
        in.close();

        String fileAsString = new String(buffer);

        return new Gson().fromJson(fileAsString, type);
    }

}
