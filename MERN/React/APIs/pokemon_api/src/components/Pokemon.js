import React, {useState} from "react";
const Pokemon = (props) => {
    const [pokemons, setPokemons] = useState([]);

    const handler = ()=>{
        fetch('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0')
        .then(response => response.json())
        .then(response => setPokemons(response.results))
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
            </div>
        </div>
    );
}
export default Pokemon;