import React, {useState} from "react";
import axios from 'axios';
const Pokemon = (props) => {
    const [pokemons, setPokemons] = useState([]);

    const handler = ()=>{
        axios.get("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0").then(response=>{setPokemons(response.data.results)})
    }
    return (
        <div>
            <div>
            <button onClick={handler}>Fetch Pokemons</button>
            </div>
            <div>
                {pokemons.map((pokemon, index)=>{
                    return (<div key={index}>{pokemon.name}</div>)
                })}
                {/* {pokemons} */}
            </div>
        </div>
    );
}
export default Pokemon;