import Home from './components/Home.js';
import { Route, Routes } from 'react-router-dom';
import Draw from './components/Draw.js';
import Mypage from './components/Mypage.js';
import Join from './components/Join';
import Help from './components/Help';
import Login from './components/Login';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/help" element={<Help />} />
        <Route path="/home" element={<Home />} />
        <Route path="/draw" element={<Draw />} />
        <Route path="/mypage" element={<Mypage />} />
        <Route path="/" element={<Login />} />
        <Route path="/join" element={<Join />} />
      </Routes>
    </div>
  );
}

export default App;
