import React from 'react';
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import AuthorForm from './views/AuthorForm';
import Main from './views/Main';
import Update from './views/Update';

function App() {
  return (
    <BrowserRouter>
    <h2 style={{marginLeft: 50}}>Favorite authors</h2>
    <Routes>
        <Route path="/" element = {<Main />} />
        <Route path="/new" element = {<AuthorForm />} />
        <Route path="/edit/:id" element = {<Update />} />
    </Routes>

    </BrowserRouter>
  );
}
export default App;
