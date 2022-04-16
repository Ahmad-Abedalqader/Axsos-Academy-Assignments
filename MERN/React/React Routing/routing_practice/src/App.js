import './App.css';
import {
  BrowserRouter,
  Switch,
  Route
} from "react-router-dom";
import Number from './components/Number';
import Home from './components/Home';
import Word from './components/Word';

function App() {
  return (
    <BrowserRouter>
    <Switch>
    <Route path="/home">
        <Home/>
      </Route>
      <Route exact path="/:number">
        <Number/>
      </Route>
      <Route path="/:word/:color/:backgroundColor">
        <Word/>
      </Route>
    </Switch>
  </BrowserRouter>
  );
}

export default App;
