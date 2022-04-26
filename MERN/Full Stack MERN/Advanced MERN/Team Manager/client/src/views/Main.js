import React from 'react';
import PlayersList from '../compnents/PlayersList';
import { Link, Route, Routes } from 'react-router-dom';
import PlayerForm from '../compnents/PlayerForm';
import PlayerStatus from './PlayerStatus';

const Main = () => {
    return (
        <div className='container mt-4'>
            <div className='row justify-content-center'>
                <div className='col-md-8 border p-4'>
                    <div className='row justify-content-center'>
                        <Routes>
                            <Route path="players/addplayer" element={<PlayerForm />} />
                            <Route path="players/list" element={<PlayersList />} />
                            <Route path='/status/game/:id' element={<PlayerStatus />} />
                        </Routes>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Main;