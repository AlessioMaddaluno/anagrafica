import { FormGroup } from "@angular/forms";

export class CustomValidators {

  static matchingPassword(formGroup: FormGroup){
    const password = formGroup.get('password');
    const rpassword = formGroup.get('rpassword');
    return password === rpassword ? null : { passwordNotMatch: true };
  }


}
