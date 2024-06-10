import {Event} from "./event";
import {User} from "./User";

export interface Registration {
  registrationId: string;
  user:User;
  event:Event;
  registrationDate:Date;
}

export type RegistrationCreateInput = Omit<Registration, "registrationId" | 'event' | 'user' | 'registrationDate'> & {
userId:string;
eventId:string;
};
