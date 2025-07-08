export interface Type{
  id:string;
  name:string;
}

export type TypeCreateInput = Omit<Type, 'id'>
