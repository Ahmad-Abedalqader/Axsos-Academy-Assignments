import React, { useEffect, useState } from 'react';
import ProductForm from '../compnents/ProductForm';
import ProductsList from '../compnents/ProductsList';
import axios from 'axios';
const Main = (props) => {
    const [products, setProducts] = useState([]);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(()=>{
        axios.get('http://localhost:8000/api/products')
            .then(res=>{
                setProducts(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);

    const removeFromDom = productId => {
        setProducts(products.filter(product => product._id != productId));
    }
    return (
        <div>
            <ProductForm/>
            <hr/>
            {loaded && <ProductsList products = {products} removeFromDom={removeFromDom} /> }
        </div>
    )
}
    
export default Main;