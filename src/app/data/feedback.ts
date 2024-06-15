import {GameEvent} from "./gameEvent";
import {User} from "./User";

export interface Feedback {
  feedbackId: string;
  event: GameEvent;
  rating: number;
  comments: string;
  user: User;
  feedbackDate :Date;
}

export type FeedbackCreateInput = Omit<Feedback, 'feedbackId' | 'feedbackDate' | 'user' | 'event'>&{
  eventId: string;
  userId: string;
}
