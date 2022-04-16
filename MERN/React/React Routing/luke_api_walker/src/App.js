import {
  BrowserRouter,
  Switch,
  Route
} from "react-router-dom";
import Result from './components/Result';
import Home from './components/Home';

function App() {

  return (
    <BrowserRouter forceRefresh="true">
    <Switch>
    <Route exact path="/">
        <Home />
      </Route>
      <Route exact path="/:resource/:id">
        <Home />
        <Result />
      </Route>
    </Switch>
  </BrowserRouter>
  );
}

export default App;
