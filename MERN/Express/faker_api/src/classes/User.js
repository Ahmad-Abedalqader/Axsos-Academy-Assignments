class User {
    constructor(id, firstName, lastName, email, phoneNumber) {
        this._id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
module.exports = User;