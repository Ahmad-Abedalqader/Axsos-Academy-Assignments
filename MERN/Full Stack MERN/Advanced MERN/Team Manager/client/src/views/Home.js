import React from 'react'
import { Link, Routes, Route } from 'react-router-dom'
import Main from './Main'

const Home = () => {
    return (
        <div className='container mt-4'>
            <div className='row justify-content-center'>
                <div className='col-md-8'>
                    <p>
                        <Link to="/players/list" className='h5'>Manage Players</Link> |{" "}
                        <Link to="/status/game/1" className='h5'>Manage Player Status</Link>
                    </p>
                </div>
            </div>
            <Main />
        </div>
    )
}

export default Home