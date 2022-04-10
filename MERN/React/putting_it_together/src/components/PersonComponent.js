import React, { Component } from 'react';
    
    
class PersonComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            age: this.props.age
        };
    }
    render() {
        const { firstName, lastName, hairColor } = this.props;
        return <>
                    <h1>{ lastName}, { firstName }</h1>
                    <p>age: {this.state.age}</p>
                    <p>Hair color: {hairColor}</p>
                    <button onClick={ () => this.setState({age: this.state.age+1}) }>Birthday Button for {firstName} { lastName}</button>
                </>;
    }
}
    
export default PersonComponent;