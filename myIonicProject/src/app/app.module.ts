import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { HelloIonicPage } from '../pages/hello-ionic/hello-ionic';
import { HTTP }           from '@ionic-native/http';
import { ItemDetailsPage } from '../pages/item-details/item-details';
import { ListPage } from '../pages/list/list';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { AngularFireModule } from 'angularfire2';
//import { FirebaseProvider } from './../providers/firebase/firebase';
import { FirebaseProvider } from '../providers/firebase/firebase';

const firebaseConfig = {
  apiKey: "AIzaSyDOSUr-zfIhbYfv570NrhCmMl3SFc6m7F8",
      authDomain: "android-demo-137b5.firebaseapp.com",
      databaseURL: "https://android-demo-137b5.firebaseio.com",
      projectId: "android-demo-137b5",
      storageBucket: "android-demo-137b5.appspot.com",
      messagingSenderId: "615088082360"
  };

@NgModule({
  declarations: [
    MyApp,
    HelloIonicPage,
    ItemDetailsPage,
    ListPage
  ],
  imports: [
    BrowserModule,
    AngularFireDatabaseModule,
    AngularFireModule.initializeApp(firebaseConfig),
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HelloIonicPage,
    ItemDetailsPage,
    ListPage
  ],
  providers: [
    HTTP,
    StatusBar,
    SplashScreen,
    FirebaseProvider,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
  ]
})
export class AppModule {}
