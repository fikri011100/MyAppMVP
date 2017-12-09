package com.santriprogrammer.myappmvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.santriprogrammer.myappmvp.model.PojoMain;

/**
 * Created by fikriimaduddin on 09/12/17.
 */

public class MainActivityDataRemote implements MainActivityDataResource {

  Context context;
  //url yang ada di WA
  private String url = "http://api.themoviedb.org/3/movie/top_rated?api_key=d0a67526a3d2f792f62893d7f963ae55";

  public MainActivityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getMainActivityList(@NonNull final MainActivityGetCallBack mainActivityGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(url),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            final PojoMain pojoMain = new Gson().fromJson(response, PojoMain.class);
            Log.i("response", response);
            if (pojoMain == null) {
              mainActivityGetCallBack.onError("Error");
            } else {
              mainActivityGetCallBack.onSuccses(pojoMain.getResults());
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        mainActivityGetCallBack.onError("Error");
      }
    });
    requestQueue.add(stringRequest);
  }
}
