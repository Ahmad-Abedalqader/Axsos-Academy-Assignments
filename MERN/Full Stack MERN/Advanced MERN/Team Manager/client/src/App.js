import React from 'react';
import {
  BrowserRouter,
  Route,
  Routes,
} from "react-router-dom";
import Home from './views/Home';

import Main from './views/Main';
import PlayerStatus from './views/PlayerStatus';


function App() {
  return (
    <BrowserRouter>
      <Home/>
    </BrowserRouter>
  
  );
}
export default App;
