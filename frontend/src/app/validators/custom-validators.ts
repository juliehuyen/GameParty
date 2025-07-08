import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function dateNotBeforeTodayValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const currentDate = new Date().setHours(0, 0, 0, 0);
    const selectedDate = new Date(control.value).setHours(0, 0, 0, 0);
    return selectedDate < currentDate ? { dateNotBeforeToday: true } : null;
  };
}
