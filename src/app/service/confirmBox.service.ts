import { ConfirmBoxInitializer, DialogLayoutDisplay } from "@costlydeveloper/ngx-awesome-popup";
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class  ConfirmBoxService {
  // confirmBoxDeleteLoad() {
  //   const confirmBox = new ConfirmBoxInitializer();
  //   confirmBox.setTitle('This book has been deleted by someone else!');
  //   confirmBox.setMessage('Do you want to reload the page?');
  //   confirmBox.setButtonLabels('Yes', 'No');
  //   confirmBox.setConfig({
  //       LayoutType: DialogLayoutDisplay.WARNING // SUCCESS | INFO | NONE | DANGER | WARNING
  //   });
  //   return confirmBox
  // }
}
