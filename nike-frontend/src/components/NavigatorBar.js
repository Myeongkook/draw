import React from 'react';
import '../css/NavigatorBar.css';
import { AiOutlineHome, AiOutlineUser } from 'react-icons/ai';
import { SiNike } from 'react-icons/si';

const NavigatorBar = () => {
  return (
    <div className="navi-bar">
      <div className="draw">
        <SiNike />
        THE DRAW
      </div>
      <div className="home">
        <AiOutlineHome />
        HOME
      </div>
      <div className="mypage">
        <AiOutlineUser />
        MY PAGE
      </div>
    </div>
  );
};

export default NavigatorBar;
