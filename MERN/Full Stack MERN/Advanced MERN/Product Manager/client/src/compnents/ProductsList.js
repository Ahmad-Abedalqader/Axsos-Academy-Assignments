import React from 'react'
import {
    Link,
} from "react-router-dom";
import DeleteButton from './deleteButton';
import axios from 'axios';
import { useState, useEffect } from 'react';
const ProductsList = (props) => {
    const {removeFromDom} = props;

    return (
        <div style={{marginLeft:50}}>
            {props.products.map( (prod, i) =>{
                return <p key={i}>
                    <Link to={`/products/${prod._id}`} style={{marginRight: 20}}>{prod.title} </Link>
                    <DeleteButton productId = {prod._id} successCallback = {()=> removeFromDom(prod._id)} />
                </p>
            })}
        </div>
    )
}
    
export default ProductsList;