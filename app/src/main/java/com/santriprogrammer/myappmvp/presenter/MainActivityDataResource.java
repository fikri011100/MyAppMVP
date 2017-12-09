package com.santriprogrammer.myappmvp.presenter;

import android.support.annotation.NonNull;
import com.santriprogrammer.myappmvp.model.PojoMain;
import java.util.List;

/**
 * Created by fikriimaduddin on 09/12/17.
 */

public interface MainActivityDataResource {

  interface MainActivityGetCallBack {

    void onSuccses(List<PojoMain.ResultsBean> data);

    void onError(String msg);
  }

  void getMainActivityList(@NonNull MainActivityGetCallBack mainActivityGetCallBack);
}
