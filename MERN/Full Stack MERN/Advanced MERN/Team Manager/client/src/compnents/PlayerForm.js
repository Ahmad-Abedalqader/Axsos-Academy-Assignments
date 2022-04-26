import React, { useState } from 'react'
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

const PlayerForm = (props) => {
    //keep track of what is being typed via useState hook
    const [name, setName] = useState("");
    const [prefPos, setPrefPos] = useState("");
    const navigate = useNavigate();
    const [error, setError] = useState([]);
    const [msg, setMsg] = useState("");
    //handler when the form is submitted
    const onSubmitHandler = e => {
        //prevent default behavior of the submit
        e.preventDefault();
        //make a post request to create a new player
        axios.post('http://localhost:8000/api/player/new', {
            name, prefPos
        })
            .then(res => {
                console.log(res)
                navigate("/players/list")
            })
            .catch((err) => {
                console.log("Error, ", err.response.data.errors.name.message);
                setError(err.response.data.errors.name.message);
            });
    }
    const onChangeHandler = (e) => {
        const name = e.target.value
        setName(name)
        if (name.length < 2 && name.length > 0) {
            setMsg("Name must be 2 characters at least!");
        } else if (name.length === 0) {
            setMsg("");
        } else {
            setMsg("Looks Perfect!");
        }
    }
    return (

        <div className='container'>
            <div className='row p-3'>
                <div className='col-md-5'>
                    <p>
                        <Link to="/players/list" className='h5'>List</Link> |{" "}
                        <Link to="/players/addplayer" className='h5'>Add Player</Link>
                    </p>
                </div>
            </div>
            <div className='row justify-content-center  border p-3'>
                <div className='col-md-6'>
                    <form onSubmit={onSubmitHandler} >
                        <h4>Add a new player</h4>
                        <div>
                            {error && (<div id="error" className="form-text" style={{ color: 'red' }}>{error} </div>)}
                            <div id="error" className="form-text" style={msg === "Looks Perfect!" ? { color: 'green' } : { color: 'red' }}>{msg} </div>
                            <div className="mb-3 form-floating">
                                <input
                                    type="text" className="form-control mt-2" id="name" aria-describedby="error" placeholder='Player Name'
                                    onChange={onChangeHandler}
                                    value={name}
                                />
                                <label htmlFor="name" >Player Name:</label>
                            </div>
                        </div>

                        <div className="form-floating mb-3">

                            <input
                                type="text" className="form-control" id="position"
                                onChange={(e) => setPrefPos(e.target.value)}
                                value={prefPos}
                                placeholder='Prefered Position'
                            />
                            <label htmlFor="position" className="form-label">Prefered positon:</label>
                        </div>
                        <button type="submit"
                            className="btn btn-primary btn-sm"
                            disabled={name.length >= 2 ? false : true}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default PlayerForm;
