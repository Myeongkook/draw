import Home from './pages/Home.js';
import { Route, Routes } from 'react-router-dom';
import NavigatorBar from './components/NavigatorBar.js';
import Menu from './components/Menu.js';
import { GrMenu } from 'react-icons/gr';
import Draw from './components/Draw.js';
import Mypage from './components/Mypage.js';
import { useState } from 'react';
import Join from './pages/Join';
import Login from './pages/Login';

function App() {
  return (
    <div className="App">
      <Routes>
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
