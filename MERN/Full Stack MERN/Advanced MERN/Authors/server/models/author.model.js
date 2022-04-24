const mongoose = require('mongoose');
const AuthorSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "{PATH} is required" ],
        minlength: [3, "{PATH} must be {MINLENGTH} characters at least"]
    },
}, { timestamps: true });

module.exports.Author = mongoose.model('Author', AuthorSchema);