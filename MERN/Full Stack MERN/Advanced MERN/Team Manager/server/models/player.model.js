const mongoose = require('mongoose');
const PlayerSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "{PATH} is required" ],
        minlength: [2, "Player {PATH} must be {MINLENGTH} characters at least"]
    },
    prefPos: {type: String},
    game1: { type: String, default: "undecided" },
    game2: { type: String, default: "undecided" },
    game3: { type: String, default: "undecided" },
}, { timestamps: true });

module.exports.Player = mongoose.model('Player', PlayerSchema);