import { Injectable } from '@angular/core';

import { AngularFireDatabase } from 'angularfire2/database';


@Injectable()
export class FirebaseProvider {

  constructor(public afd: AngularFireDatabase) { }

  getShoppingItems() {

    return this.afd.object("/Toaast Input/").valueChanges();


  }

  addItem(name) {
    this.afd.list('/Toaast Input').push(name);
  }
  //
  // removeItem(id) {
  //   this.afd.list('/shoppingItems/').remove(id);
  // }
}
