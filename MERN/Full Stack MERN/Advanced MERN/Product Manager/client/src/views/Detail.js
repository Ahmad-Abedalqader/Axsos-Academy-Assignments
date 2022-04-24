import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, useNavigate, useParams } from "react-router-dom";
import DeleteButton from '../compnents/deleteButton';
    
const Detail = (props) => {
    const [product, setProduct] = useState({})
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8000/api/products/'+id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err));
    }, []);

    return (
        <div style={{margin:50}}>
            <p><strong>Title: </strong> {product.title}</p>
            <p><strong>Price: </strong> ${product.price}</p>
            <p><strong>Description: </strong> {product.desc}</p>
            <Link to={"/" + product._id + "/edit"} style={{marginRight: 20}}> Edit</Link>
            <DeleteButton productId = {product._id} successCallback = {()=> navigate("/products")} />
        </div>
    )
}
    
export default Detail;