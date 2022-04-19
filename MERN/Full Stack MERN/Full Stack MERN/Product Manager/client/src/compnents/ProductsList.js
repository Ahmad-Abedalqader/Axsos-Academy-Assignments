import React from 'react'
import {
    Link,
} from "react-router-dom";
import axios from 'axios';

const ProductsList = (props) => {
    const { removeFromDom } = props;
    
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/products/' + productId)
            .then(res => {
                removeFromDom(productId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div style={{marginLeft:50}}>
            {props.products.map( (prod, i) =>{
                return <p key={i}>
                    <Link to={`/products/${prod._id}`} style={{marginRight: 20}}>{prod.title} </Link>
                    <button onClick={(e)=>{deleteProduct(prod._id)}}> Delete</button>
                </p>
            })}
        </div>
    )
}
    
export default ProductsList;