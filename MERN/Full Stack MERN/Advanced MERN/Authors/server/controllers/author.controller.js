const { Author } = require('../models/author.model');

module.exports.createAuthor = (request, response) => {
    const {name} = request.body;
    Author.create({
        name
    })
        .then(author => response.json(author))
        .catch((err) => {
            response.status(400).send(err);
        });
}
module.exports.getAllAuthors = (request, response) => {
    Author.find({})
        .then(authors => response.json(authors))
        .catch(err => response.json(err))
}
module.exports.getAuthor = (request, response) => {
    Author.findOne({_id:request.params.id})
        .then(author => response.json(author))
        .catch(err => response.json(err))
}
module.exports.updateAuthor = (req, res) => {
    const { id } = req.params;
    const { name } = req.body;
    Author.findOneAndUpdate(
        { _id: id },
        { name },
        { runValidators: true, new: true }
        )
        .then((updatedAuthor) => res.json(updatedAuthor))
        .catch((err) => {
            res.status(400).send(err);
        });
};

module.exports.deleteAuthor = (req, res) => {
    const { id } = req.params;
    Author.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};