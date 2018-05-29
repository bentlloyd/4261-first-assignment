import { Component } from '@angular/core';
import { HTTP }      from '@ionic-native/http';
import { FirebaseProvider } from '../../providers/firebase/firebase';
import { Observable } from 'rxjs';
@Component({
  selector: 'page-hello-ionic',
  templateUrl: 'hello-ionic.html'
})
export class HelloIonicPage {

  item: string;
  weather: number;
  constructor(
    private http:HTTP,
    private fb: FirebaseProvider
  ) {
    this.getWeather();

  }

  submitName(userName) {
    this.http.put("https://tat06mwtnd.execute-api.us-east-1.amazonaws.com/test", {}, {}).then(
      (result) => {
        console.log(result);
      }
    );
  }
  read() {
    console.log("entering");
    this.fb.getShoppingItems().subscribe(
      data => {
        this.item = JSON.stringify(data);
      }
    );
  }

  getWeather() {
    this.http.post("https://api.openweathermap.org/data/2.5/weather?q=London&APPID=173a65fcdabd43e759c98e10cba240a4", {}, {}).then(
      (result) => {
        console.log(result);
        let x = JSON.parse(result.data);
        console.log(x);
        this.weather = x.main.temp;
        // this.weather = JSON.stringify(result.data.);
      }
    );

  }


}
