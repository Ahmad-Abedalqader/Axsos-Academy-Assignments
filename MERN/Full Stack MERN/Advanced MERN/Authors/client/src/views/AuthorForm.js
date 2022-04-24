import React, { useState } from 'react'
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

const AuthorForm = () => {
    //keep track of what is being typed via useState hook
    const [name, setName] = useState("");
    const navigate = useNavigate();
    const [error, setError] = useState(null);
    //handler when the form is submitted
    const onSubmitHandler = e => {
        //prevent default behavior of the submit
        e.preventDefault();
        //make a post request to create a new author
        axios.post('http://localhost:8000/api/author/new', {
            name
        })
            .then(res => {
                console.log(res)
                navigate("/")
            })
            .catch((err) => {
                console.log("Error, ", err.response.data.errors.name.message);
                setError(err.response.data.errors.name.message);
            });

    }
    return (
        <>
            <Link to={"/"}>Home</Link>
            <h3>Add a new author:</h3>
            <form onSubmit={onSubmitHandler} style={{ marginLeft: 50, border: "1px solid gray" }}>
                <p>
                    <label>Name:</label><br />
                    <input type="text" onChange={(e) => setName(e.target.value)} value={name} />
                    {error && (
                        <>
                        <br />
                        <span style={{color:"red"}}>
                            {error}
                        </span>
                        </>
                    )}
                </p>
                <input type="submit" />
                <button><Link to={"/"}>Cancel</Link></button>
            </form>
        </>
    )
}

export default AuthorForm;
