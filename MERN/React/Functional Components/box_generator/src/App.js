import './App.css';
import BoxComponent from './components/BoxComponent';
import {useState} from "react";
import FormComponent from './components/FormComponent';
function App() {
  const [boxes, setBoxes] = useState([]);
  const setBoxesFun= (color)=>{
    setBoxes([...boxes, color]);
  }

  return (
    <div className="App">
      <FormComponent myFun = {setBoxesFun}/>
      <BoxComponent myBoxes = {boxes}/>
    </div>
  );
}

export default App;
