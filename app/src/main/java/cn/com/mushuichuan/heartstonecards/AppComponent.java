/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package cn.com.mushuichuan.heartstonecards;

import javax.inject.Singleton;

import cn.com.mushuichuan.heartstonecards.api.ApiModule;
import cn.com.mushuichuan.heartstonecards.api.IApi;
import cn.com.mushuichuan.heartstonecards.api.NetworkModule;
import cn.com.mushuichuan.heartstonecards.ui.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, ApiModule.class,})
public interface AppComponent {
    void inject(MainApp app);

    void inject(MainActivity mainActivity);

//    public IApi provideApi();
}
