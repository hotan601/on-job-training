import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class ValidationMessage {
  getErrorMessage(property: string, validation: any): string {
    let message: string;
    switch(Object.keys(validation)[0]) {
      case "required":
        message = `${property} is required`;
        break;
      case "min":
        message = `${property} must be greater than ${validation.min.min}`;
        break;
      case "max":
        message = `${property} must be less than ${validation.max.max}`;
        break;
      case "minlength":
        message = `${property} must be at least ${validation.minlength.requiredLength} characters`;
        break;
      case "maxlength":
        message = `${property} must be less than ${validation.maxlength.requiredLength} characters`;
        break;
      case "shouldBeUnique":
        console.log(validation);
        message = `This ${property} already existed!`;
        break;
      case "date":
        console.log(validation);
        message = `${property} is not passed date now`;
        break;
      default:
        message = "invalid input";
    }
    return (
      message.toLowerCase().charAt(0).toUpperCase() +
      message.slice(1).toLowerCase()
    );
  }
}
