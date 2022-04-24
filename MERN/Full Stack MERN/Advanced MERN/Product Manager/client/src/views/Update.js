import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import ProductForm from '../compnents/ProductForm';
import { useNavigate } from 'react-router-dom';
import DeleteButton from '../compnents/deleteButton';

const Update = (props) => {
    const { id } = useParams();
    const [product, setProduct] = useState();
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + id)
            .then(res => {
                setProduct(res.data);
                setLoaded(true);
            })
    }, []);
    
    const updateProduct = (product) => {
        axios.put('http://localhost:8000/api/products/' + id, product )
            .then(res => console.log(res))
            .catch(err => console.error(err));
    }
    
    return (
        <div style={{marginLeft: 50}}>
            <h2>Update a Product</h2>
            {loaded && (
                <><ProductForm
                    onSubmitProp={updateProduct}
                    initialTitle={product.title}
                    initialPrice={product.price}
                    initialDesc={product.desc} />
                    <DeleteButton productId={product._id} successCallback={() => navigate("/products")} />
                </>
            )}
        </div>
    )
}
export default Update;