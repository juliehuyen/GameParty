import {GameEvent} from "./gameEvent";
import {User} from "./User";

export interface Registration {
  registrationId: string;
  user:User;
  event:GameEvent;
  registrationDate:Date;
}

export type RegistrationCreateInput = Omit<Registration, "registrationId" | 'event' | 'user' | 'registrationDate'> & {
userId:string;
eventId:string;
};
