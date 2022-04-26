const { Player } = require('../models/player.model');

module.exports.createPlayer = (request, response) => {
    const {name, prefPos} = request.body;
    Player.create({
        name,
        prefPos
    })
        .then(player => response.json(player))
        .catch((err) => {
            response.status(400).json(err);
        });
}
module.exports.getAllPlayers = (request, response) => {
    Player.find({})
        .then(players => response.json(players))
        .catch(err => response.json(err))
}
module.exports.getPlayer = (request, response) => {
    Player.findOne({_id:request.params.id})
        .then(player => response.json(player))
        .catch(err => response.json(err))
}
module.exports.updatePlayer = (req, res) => {
    const { id } = req.params;
    const { name, prefPos, game1, game2, game3 } = req.body;
    Player.findOneAndUpdate(
        { _id: id },
        { name, prefPos, game1, game2, game3 },
        { runValidators: true, new: true }
        )
        .then((updatedPlayer) => res.json(updatedPlayer))
        .catch((err) => {
            res.status(400).json(err);
        });
};

module.exports.deletePlayer = (req, res) => {
    const { id } = req.params;
    Player.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};