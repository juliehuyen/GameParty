export interface User {
  userId: string;
  username: string;
}

export type UserCreateInput = Omit<User, 'userId'>;
