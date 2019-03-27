export class SignUpInfo {
    lastName: string;
    firstName: string;
    username: string;
    email: string;
    role: string[];
    password: string;
    birthDate: Date;

    constructor(lastName: string, firstName: string, username: string, email: string, password: string, birthDate:Date) {
        this.lastName=lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = ['user'];
        this.birthDate = birthDate;
    }
}
