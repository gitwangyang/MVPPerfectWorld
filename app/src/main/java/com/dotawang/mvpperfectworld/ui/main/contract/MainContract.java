package com.dotawang.mvpperfectworld.ui.main.contract;

import com.dotawang.mvpperfectworld.base.BasePresenter;
import com.dotawang.mvpperfectworld.base.IModel;
import com.dotawang.mvpperfectworld.base.IView;

import java.util.List;

/**
 * Created on 2019/3/22
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public interface MainContract {
    interface View extends IView {
        void setData();

        void setDataCount(List<Integer> listNum);
    }

    interface Model extends IModel {
        void requestData();

        void setOnMainDataCallback(OnMainDataCallback onMainDataCallback);

        interface OnMainDataCallback {
            void onSuccess(List<Integer> listNum);

            void onFailure();
        }
    }

    abstract class Presenter<V extends MainContract.View, M extends MainContract.Model> extends BasePresenter<V, M> {
        public abstract void requestMainData();
    }
}
