import React from 'react'
import {
    Link, useNavigate,
} from "react-router-dom";
import axios from 'axios';

const AuthorsList = (props) => {
    const { removeFromDom } = props;
    const navigate = useNavigate();

    const deleteAuthor = (authorId) => {
        axios.delete('http://localhost:8000/api/authors/' + authorId)
            .then(res => {
                removeFromDom(authorId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div style={{ marginLeft: 50 }}>
            <Link to={"/new"}>add an author</Link>
            <p>We have qoutes by:</p>
            <table>
                <thead>
                    <tr>
                        <th>Author</th>
                        <th>Actions Available</th>
                    </tr>
                </thead>
                <tbody>
                {props.authors.map((auth, i) => {
                    return(
                        <tr>
                        <td key={i}>{auth.name}</td>
                        <td><button><Link to={"/edit/"+auth._id} style={{textDecorationLine: 'none'}}>Edit</Link></button> </td>
                        <td><button onClick={(e) => { deleteAuthor(auth._id); } }> Delete</button></td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        </div>
    )
}

export default AuthorsList;