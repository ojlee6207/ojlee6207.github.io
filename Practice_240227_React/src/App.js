import logo from './logo.svg';
import './App.css';

import Board from './components/Board';
import Game from './pages/Game';
import Login from './pages/Login';
import HobbyList from './pages/HobbyList';
import Counter from './pages/Counter';

function App(){
  return (
    <div className="App">
      {/* <Game /> */}
      {/* <Login /> */}
      {/* <HobbyList /> */}
      <Counter />
    </div>
  )
}
// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default App;
