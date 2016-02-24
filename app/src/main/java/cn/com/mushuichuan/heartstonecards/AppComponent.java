/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package cn.com.mushuichuan.heartstonecards;

import javax.inject.Singleton;

import cn.com.mushuichuan.heartstonecards.api.ApiModule;
import cn.com.mushuichuan.heartstonecards.api.NetworkModule;
import cn.com.mushuichuan.heartstonecards.ui.BaseActivity;
import cn.com.mushuichuan.heartstonecards.ui.fragments.BaseFragment;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ApiModule.class, AppModule.class})
public interface AppComponent {
    void inject(MainApp app);

    void inject(BaseActivity baseActivity);

    void inject(BaseFragment baseFragment);
}
