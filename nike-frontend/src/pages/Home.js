import React from 'react';
import NavigatorBar from '../components/NavigatorBar';
import { GrMenu } from 'react-icons/gr';
import Menu from '../components/Menu';
import Draw from '../components/Draw';
import Mypage from '../components/Mypage';

const Home = () => {
  const activeMenu = () => {
    document.getElementsByClassName('menu')[0].classList.add('active');
  };

  return (
    <div className="Home">
      <Menu />
      <div className="header" onClick={activeMenu}>
        <GrMenu />
      </div>
      <div className="content">
        <Draw />
        <Mypage />
      </div>
      <NavigatorBar />
    </div>
  );
};

export default Home;
