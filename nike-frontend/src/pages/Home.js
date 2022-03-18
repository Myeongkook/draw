import React from 'react';
import NavigatorBar from '../components/NavigatorBar';
import { AiOutlineMenu } from 'react-icons/ai';

const Home = () => {
  return (
    <div className="Home">
      <div className="header">
        <AiOutlineMenu />
      </div>
      <div className="content"></div>
      <NavigatorBar />
    </div>
  );
};

export default Home;
