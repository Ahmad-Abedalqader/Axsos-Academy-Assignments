import './App.css';

import PersonComponent from './components/PersonComponent';

function App() {
  return (
    <div className="App">
      < PersonComponent firstName = "Jane" lastName = "Doe" age = {45} hairColor = "Black" />
      < PersonComponent firstName = "John" lastName = "Smith" age = {88} hairColor = "Brown" />
      < PersonComponent firstName = "Millard" lastName = "Fillmore" age = {50} hairColor = "Brown" />
      < PersonComponent firstName = "Maria" lastName = "Smith" age = {62} hairColor = "Brown" />
    </div>
  );
}
export default App;
