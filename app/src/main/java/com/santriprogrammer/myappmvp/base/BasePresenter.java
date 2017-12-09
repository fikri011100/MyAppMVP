package com.santriprogrammer.myappmvp.base;

/**
 * Created by fikriimaduddin on 09/12/17.
 */

public interface BasePresenter<T> {

  void onAttachView(T view);

}
