import React, {useState} from 'react'

const FormComponent = (props) => {
    const [color, setColor] = useState("");
    const createBox = (e)=>{
        e.preventDefault();
        props.myFun(color);
        setColor("");
    }
    return (
        <div>
            <form onSubmit={ createBox }>
                <div>
                    <label>Color: </label> 
                    <input type="text" onChange={ (e) => setColor(e.target.value) } value={ color } />
                    <input type="submit" value="Add" />
                </div>
            </form>
        </div>
    )
}

export default FormComponent