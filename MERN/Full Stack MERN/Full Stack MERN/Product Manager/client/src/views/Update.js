import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
    
const Update = (props) => {
    const { id } = useParams();
    const [title, setTitle] = useState(""); 
    const [price, setPrice] = useState(0);
    const [desc, setDesc] = useState("");
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + id)
            .then(res => {
                setTitle(res.data.title);
                setPrice(res.data.price);
                setDesc(res.data.desc);
            })
    }, []);
    
    const updateProduct = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/products/' + id, {
            title,
            price,
            desc
        })
            .then(res => console.log(res))
            .catch(err => console.error(err));
    }
    
    return (
        <div style={{marginLeft: 50}}>
            <h2>Update a Product</h2>
            <form onSubmit={updateProduct}>
                <p>
                    <label>Title:</label><br />
                    <input type="text" 
                    name="title" 
                    value={title} 
                    onChange={(e) => { setTitle(e.target.value) }} />
                </p>
                <p>
                    <label>Price:</label><br />
                    <input type="number" 
                    name="price"
                    value={price} 
                    onChange={(e) => { setPrice(e.target.value) }} />
                </p>
                <p>
                    <label>Description:</label><br />
                    <input type="text" 
                    name="desc"
                    value={desc} 
                    onChange={(e) => { setDesc(e.target.value) }} />
                </p>
                <input type="submit" />
            </form>
        </div>
    )
}
export default Update;