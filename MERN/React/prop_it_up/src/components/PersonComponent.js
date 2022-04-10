import React, { Component } from 'react';
    
    
class PersonComponent extends Component {
    render() {
        const { firstName, lastName, age, hairColor } = this.props
        return <>
                    <h1>{ lastName}, { firstName }</h1>
                    <p>age: {age}</p>
                    <p>Hair color: {hairColor}</p>
                </>;
    }
}
    
export default PersonComponent;