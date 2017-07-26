export class User {
  constructor(public userId: number, public firstName: string, public lastName: string,
              public email: string, public login: string, public password: string, public fkRole: number) {
  }
}
