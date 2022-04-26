import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';


const PlayersList = () => {
    const [players, setPlayers] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8000/api/players')
            .then(res => {
                setPlayers(res.data);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = playerId => {
        setPlayers(players.filter(player => player._id !== playerId));
    }

    const deletePlayer = (playerId, name) => {
        if (window.confirm(`Are you sure you want to delete ${name}?`)) {
            axios.delete(`http://localhost:8000/api/players/${playerId}`)
                .then((res) => {
                    console.log(res);
                    removeFromDom(playerId);
                })
                .catch((err) => console.error(err));
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
            <div className='row justify-content-center border p-4'>
                    <table className='table table-primary table-striped' style={{ maxWidth: 500 }}>
                        <thead>
                            <tr>
                                <th>Player</th>
                                <th>Prefered position</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {players.map((player, i) => {
                                return (
                                    <tr>
                                        <td key={i}>{player.name}</td>
                                        <td>{player.prefPos}</td>
                                        <td><button onClick={(e) => { deletePlayer(player._id, player.name); }} className='btn btn-danger btn-sm'> Delete</button></td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>
                </div>
            </div>
    )
}

export default PlayersList;