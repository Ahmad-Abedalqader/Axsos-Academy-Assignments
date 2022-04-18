const mongoose = require("mongoose");

const JokeSchema = new mongoose.Schema({
    setup: {
        type: String,
        minlength: [10, "Setup must be 10 characters at least"],
    },
    punchline: {
        type: String,
        minlength: [3, "Punchline must be characters at least 3"],
    },
}, {timestamps: true});

const Joke = mongoose.model("Joke", JokeSchema);

module.exports = Joke;