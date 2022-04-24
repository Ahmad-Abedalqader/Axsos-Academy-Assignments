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
        setProducts(products.filter(product => product._id !== productId));
    }
    const createProduct = (product)=> {
        axios.post('http://localhost:8000/api/product/new', product )
            .then(res=>{setProducts([...products, res.data])})
            .catch(err=>console.log(err))
    }
    return (
        <div>
            <h2 style={{marginLeft:40}}>Add a Product</h2>
            <ProductForm 
            onSubmitProp = {createProduct}
            initialTitle =""
            initialPrice = {0}
            initialDesc = ""
            />
            <hr/>
            {loaded && <ProductsList products = {products} removeFromDom = {removeFromDom} /> }
        </div>
    )
}
    
export default Main;