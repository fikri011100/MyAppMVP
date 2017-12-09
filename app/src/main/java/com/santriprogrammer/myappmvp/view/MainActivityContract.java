package com.santriprogrammer.myappmvp.view;

import com.santriprogrammer.myappmvp.base.BasePresenter;
import com.santriprogrammer.myappmvp.model.PojoMain;
import java.util.List;

/**
 * Created by fikriimaduddin on 09/12/17.
 */

public class MainActivityContract {

  public interface  View {
    void onSucces(List<PojoMain.ResultsBean> data);
    void onError(String msg);
  }

  public interface Presenter extends BasePresenter<View>{
    void getData();
  }
}
