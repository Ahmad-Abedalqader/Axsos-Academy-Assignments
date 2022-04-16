import React from 'react'
import { useParams } from "react-router";

const Word = () => {
    const { word } = useParams();
    const { color } = useParams();
    const { backgroundColor } = useParams();
    return (
        <div style={{color:color, backgroundColor: backgroundColor}}>
            <h3>The word is: {word}</h3>
        </div>
    )
}

export default Word