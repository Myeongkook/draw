import React, { useState } from 'react';
import NavigatorBar from '../components/NavigatorBar';
import { GrMenu } from 'react-icons/gr';
import draw from '../components/draw';
import mypage from '../components/mypage';

const Home = () => {
  return (
    <div className="Home">
      <div className="header">
        <GrMenu />
      </div>
      <div className="content"></div>
      <NavigatorBar />
    </div>
  );
};

export default Home;
