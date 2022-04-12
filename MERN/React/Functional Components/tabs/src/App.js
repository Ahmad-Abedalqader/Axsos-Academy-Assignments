import logo from './logo.svg';
import './App.css';
import TabsComponent from './components/TabsComponent';

function App() {
  return (
    <div className="App">
        <TabsComponent tabItems ={ [
          {tab: "Tab 1", content: "Tab 1 Content is showing here!"},
          {tab: "Tab 2", content: "Tab 2 Content is showing here!"},
          {tab: "Tab 3", content: "Tab 3 Content is showing here!"}] }/>
    </div>
  );
}

export default App;
