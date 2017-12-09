package com.santriprogrammer.myappmvp.view;

import com.santriprogrammer.myappmvp.model.PojoMain.ResultsBean;
import com.santriprogrammer.myappmvp.presenter.MainActivityDataResource.MainActivityGetCallBack;
import com.santriprogrammer.myappmvp.presenter.MainActivityRepositories;
import com.santriprogrammer.myappmvp.view.MainActivityContract.View;
import java.util.List;

/**
 * Created by fikriimaduddin on 09/12/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

  MainActivityContract.View view;
  private MainActivityRepositories mainActivityRepositories;

  public MainActivityPresenter(
      MainActivityRepositories mainActivityRepositories) {
    this.mainActivityRepositories = mainActivityRepositories;
  }

  @Override
  public void onAttachView(View view) {
    this.view = view;
  }

  @Override
  public void getData() {
    mainActivityRepositories.getMainActivityList(new MainActivityGetCallBack() {
      @Override
      public void onSuccses(List<ResultsBean> data) {
        view.onSucces(data);
      }

      @Override
      public void onError(String msg) {
        view.onError(msg);
      }
    });
  }
}
