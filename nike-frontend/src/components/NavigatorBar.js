import React from 'react';
import '../css/NavigatorBar.css';
import { AiOutlineHome, AiOutlineUser } from 'react-icons/ai';
import { GiRunningShoe } from 'react-icons/gi';
import { Link } from 'react-router-dom';

const NavigatorBar = (props) => {
  const { setPage } = props;
  const changePage = (e) => {
    console.log(e.target.className);
    setPage(e.target.className);
  };
  return (
    <div className="navi-bar">
      <Link to="/draw" onClick={changePage}>
        <div className="draw">
          <GiRunningShoe />
          THE DRAW
        </div>
      </Link>
      <Link to="/home" onClick={changePage}>
        <div className="home">
          <AiOutlineHome />
          HOME
        </div>
      </Link>
      <Link to="/mypage" onClick={changePage}>
        <div className="mypage">
          <AiOutlineUser />
          MY PAGE
        </div>
      </Link>
    </div>
  );
};

export default NavigatorBar;
