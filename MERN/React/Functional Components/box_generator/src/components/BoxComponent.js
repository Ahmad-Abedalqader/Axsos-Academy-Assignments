import React from  'react';

const BoxComponent = (props) => {
    return (
        <>
        <div style={{display: "flex", flexWrap: 'wrap'}}>
            {props.myBoxes.map((color, i) => {
                const myStyle={ backgroundColor: color,
                                width:250,
                                height:250,
                                marginRight:15,
                                marginTop:15 };
                return(
                    <div key={i} style={myStyle}></div>
                )
            })}
        </div>


        </>
    )
}

export default BoxComponent