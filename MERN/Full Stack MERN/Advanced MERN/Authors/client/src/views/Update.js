import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate } from "react-router-dom";
    
const Update = (props) => {
    const { id } = useParams();
    const [name, setName] = useState("");
    const [error, setError] = useState([]);
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/authors/' + id)
            .then(res => {
                setName(res.data.name);
            })
    }, [id]);
    
    const updateAuthor = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/authors/' + id, {
            name
        })
            .then(res => {
                console.log(res)
                navigate("/")
            })
            .catch((err) => {
                console.log(err);
                setError(err.response.data.errors.name.message);
            });

    }
    
    return (
        <>
            <Link to={"/"}>Home</Link>
            <h3>Add a new author:</h3>
            <form onSubmit={updateAuthor} style={{ marginLeft: 50, border: "1px solid gray"}}>
            
            <p>
                <label>Name:</label><br />
                <input type="text" name='name' onChange={(e) => setName(e.target.value)} value={name} /><br />
                {error && (
                        <span style={{color:"red"}}>
                            {error}
                        </span>
                    )}
            </p>
            <input type="submit" />
            <button><Link to={"/"} style={{textDecorationLine: 'none'}}>Cancel</Link></button>
            </form>
        </>
    )
}
export default Update;