const { Product } = require('../models/product.model');

module.exports.createProduct = (request, response) => {
    const { title, price, desc } = request.body;
    Product.create({
        title,
        price,
        desc
    })
        .then(product => response.json(product))
        .catch(err => response.json(err));
}
module.exports.getAllProducts = (request, response) => {
    Product.find({})
        .then(products => response.json(products))
        .catch(err => response.json(err))
}
module.exports.getProduct = (request, response) => {
    Product.findOne({_id:request.params.id})
        .then(product => response.json(product))
        .catch(err => response.json(err))
}
module.exports.updateProduct = (req, res) => {
    const { id } = req.params;
    const { title, price, desc } = req.body;
    Product.findOneAndUpdate(
        { _id: id },
        { title, price, desc },
        { new: true }
        )
        .then((updatedProduct) => res.json(updatedProduct))
        .catch((err) => res.json(err));
};

module.exports.deleteProduct = (req, res) => {
    const { id } = req.params;
    Product.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};