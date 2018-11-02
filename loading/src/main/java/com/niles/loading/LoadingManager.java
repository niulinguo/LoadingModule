package com.niles.loading;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kingja.loadsir.callback.Callback;
import com.niles.appbase.ui.loading.LoaderProvider;
import com.niles.appbase.ui.loading.LoadingConfig;

/**
 * Created by Niles
 * Date 2018/11/2 13:47
 * Email niulinguo@163.com
 */
@Route(path = "/loading/service/loader")
public class LoadingManager implements LoaderProvider {

    public static LoadingConfig createLoadingConfig() {
        return new LoadingConfig.Builder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .build();
    }

    @Override
    public void init(Context context) {

    }

    @Override
    public Class<? extends Callback> error() {
        return ErrorCallback.class;
    }

    @Override
    public Class<? extends Callback> empty() {
        return EmptyCallback.class;
    }

    @Override
    public Class<? extends Callback> loading() {
        return LoadingCallback.class;
    }

    @Override
    public Class<? extends Callback> timeout() {
        return TimeoutCallback.class;
    }

    @Override
    public Class<? extends Callback> custom() {
        return CustomCallback.class;
    }
}
