import React from 'react';
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";

import Detail from './views/Detail';
import Main from './views/Main';
import Update from './views/Update';

function App() {
  return (
    <BrowserRouter>
    <Routes>
        <Route path="/products/" element = {<Main />} />
        <Route path="/products/:id" element = {<Detail />} />
        <Route path="/:id/edit" element = {<Update />} />
    </Routes>

    </BrowserRouter>
  );
}
export default App;
