import React from 'react';
import NavigatorBar from '../components/NavigatorBar';
import { GrMenu } from 'react-icons/gr';

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
