import React, { useState } from 'react'
import { useHistory } from "react-router-dom";

const resources = [
    'planets',
    'people',
    'films',
    'starships',
];

const Home = () => {
    const [selectedResource, setSelectedResource] = useState(resources[0]);
    const [id, setId] = useState("");
    const history = useHistory();

    const handleSubmit = (e)=>{
        e.preventDefault();
        history.push(`/${selectedResource}/${id}`)
    }

    return (
        <div className='container mt-5'>
            <div className='row justify-content-center'>
                <div className='col-6'>
                    <form onSubmit={handleSubmit}>
                        <label className='form-lablemt-2'>search for: </label>
                        <select className='form-select' value={selectedResource} onChange={e => setSelectedResource(e.target.value)}>
                            {resources.map( (r, i) => 
                                <option key={i} value={r}>{r}</option>
                            )}
                        </select>
                        <label className='form-lable mt-2'>ID: </label>
                        <input className='form-control' type="number" onChange={ (e) => setId(e.target.value) } value={ id } />
                        <button className='btn btn-outline-primary mt-2'>Search</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default Home