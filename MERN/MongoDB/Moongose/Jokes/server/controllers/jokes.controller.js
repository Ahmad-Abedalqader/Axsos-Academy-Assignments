const Joke = require("../models/jokes.model");

module.exports.findAllJokes = (req, res) => {
  Joke.find()
    .then((allJokes) => res.json({ jokes: allJokes }))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};

module.exports.findOneSingleJoke = (req, res) => {
  Joke.findOne({ _id: req.params.id })
    .then((singleJoke) => res.json({ joke: singleJoke }))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};

module.exports.createJoke = (req, res) => {
    Joke.exists({ setup: req.body.setup })
    .then((jokeExists) => {
        if (jokeExists) {
        // Promise.reject() will activate the .catch() below.
        return Promise.reject("This joke already exists");
        }
        return Joke.create(req.body);
    })
    .then((saveResult) => res.json(saveResult))
    .catch((err) => res.json(err));
};

module.exports.updateJoke = (req, res) => {
  Joke.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true })
    .then((updatedJoke) => res.json({ joke: updatedJoke }))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};

module.exports.deleteJoke = (req, res) => {
  Joke.deleteOne({ _id: req.params.id })
    .then((result) => res.json({ result: result }))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};