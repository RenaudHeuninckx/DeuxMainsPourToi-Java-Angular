import { IRolesEntity } from "./iroles-entity";

export interface IUser {
  sub: string;
  roles: (IRolesEntity)[];
  Id: number;
  exp: number;
  pseudo: string;
  iat: number;
}
