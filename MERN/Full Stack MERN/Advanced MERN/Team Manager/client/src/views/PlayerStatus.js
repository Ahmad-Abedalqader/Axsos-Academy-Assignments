import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';

const PlayerStatus = () => {
    const [players, setPlayers] = useState([]);
    const { id } = useParams();

    useEffect(() => {
        axios.get('http://localhost:8000/api/players')
            .then(res => {
                setPlayers(res.data);
            })
            .catch(err => console.error(err));
    }, []);

    const handleClick = (player, status, i) => {
        let updatedPlayer = {};

        if (id === "1") {
            updatedPlayer = { ...player, game1: status };
        } else if (id === "2") {
            updatedPlayer = { ...player, game2: status };
        } else if (id === "3") {
            updatedPlayer = { ...player, game3: status };
        }
        axios.put(`http://localhost:8000/api/players/${player._id}`, updatedPlayer)
            .then((res) => {
                console.log(res);
                const newPlayers = [...players];
                newPlayers[i] = updatedPlayer;
                setPlayers(newPlayers);
            })
            .catch((err) => {
                console.error(err);
            });
    };
    return (
        <div className='container mt-4'>
            <div className='row justify-content-center'>
                <div className='col-md-11 border p-4'>
                    <div className='row justify-content-center'>
                        <h3>Player Status - Game {id}</h3>
                    </div>
                    <div className='row justify-content-center'>
                        <p className='h5'>
                            <span>
                                {id === "1" ? (
                                    <span style={{ fontWeight: "bold" }}> Game 1</span>
                                ) : (
                                    <Link to="/status/game/1" style={{textDecoration: 'none'}}> Game 1</Link>
                                )}
                            </span> |
                            <span>
                                {id === "2" ? (
                                    <span style={{ fontWeight: "bold" }}> Game 2</span>
                                ) : (
                                    <Link to="/status/game/2" style={{textDecoration: 'none'}}> Game 2</Link>
                                )}
                            </span> |
                            <span>
                                {id === "3" ? (
                                    <span style={{ fontWeight: "bold" }}> Game 3</span>
                                ) : (
                                    <Link to="/status/game/3" style={{textDecoration: 'none'}}> Game 3</Link>
                                )}
                            </span>
                        </p>
                    </div>
                    <div className='row border p-4 justify-content-center'>
                        <table className='table table-primary table-striped' style={{ maxWidth: 500 }}>
                            <thead>
                                <tr>
                                    <th>Player</th>
                                    <th>Player Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                {id === "1" && (players.map((player, i) => {
                                    return (
                                        <tr>
                                            <td key={i}>{player.name}</td>
                                            <td>
                                                <td><button
                                                    className={player.game1 === 'playing' ? 'btn btn-sm btn-success me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "playing", i)}
                                                >Playing</button></td>
                                                <td><button
                                                    className={player.game1 === 'not playing' ? 'btn btn-sm btn-danger me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "not playing", i)}
                                                >Not Playing</button></td>
                                                <td><button
                                                    className={player.game1 === 'undecided' ? 'btn btn-sm btn-warning me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "undecided", i)}
                                                >Undecided</button></td>
                                            </td>
                                        </tr>
                                    )
                                }))}
                                {id === "2" && (players.map((player, i) => {
                                    return (
                                        <tr>
                                            <td key={i}>{player.name}</td>
                                            <td>
                                                <td><button
                                                    className={player.game2 === 'playing' ? 'btn btn-sm btn-success me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "playing", i)}
                                                >Playing</button></td>
                                                <td><button
                                                    className={player.game2 === 'not playing' ? 'btn btn-sm btn-danger me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "not playing", i)}
                                                >Not Playing</button></td>
                                                <td><button
                                                    className={player.game2 === 'undecided' ? 'btn btn-sm btn-warning me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "undecided", i)}
                                                >Undecided</button></td>
                                            </td>
                                        </tr>
                                    )
                                }))}
                                {id === "3" && (players.map((player, i) => {
                                    return (
                                        <tr>
                                            <td key={i}>{player.name}</td>
                                            <td>
                                                <td><button
                                                    className={player.game3 === 'playing' ? 'btn btn-sm btn-success me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "playing", i)}
                                                >Playing</button></td>
                                                <td><button
                                                    className={player.game3 === 'not playing' ? 'btn btn-sm btn-danger me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "not playing", i)}
                                                >Not Playing</button></td>
                                                <td><button
                                                    className={player.game3 === 'undecided' ? 'btn btn-sm btn-warning me-2' : 'btn btn-sm btn-light me-2'}
                                                    onClick={() => handleClick(player, "undecided", i)}
                                                >Undecided</button></td>
                                            </td>
                                        </tr>
                                    )
                                }))}
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div >
    )
}

export default PlayerStatus