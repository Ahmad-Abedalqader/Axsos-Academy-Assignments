import React from 'react'
import { useParams } from "react-router";


const Number = () => {
    const { number } = useParams();
    if (isNaN(number)) {
        return (
            <h3>The Word is: {number}</h3>
            )
    }
    else {
        return (
            <h3>The Number is: {number}</h3>
            )
    }

}

export default Number