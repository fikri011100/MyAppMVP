package com.santriprogrammer.myappmvp.presenter;

import android.content.Context;

/**
 * Created by fikriimaduddin on 09/12/17.
 */

public class MainRepoInject {
  public static MainActivityRepositories provideToMainRepo(Context context) {
    return new MainActivityRepositories(new MainActivityDataRemote(context));
  }
}
