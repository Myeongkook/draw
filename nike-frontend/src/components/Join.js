import React from 'react';
import '../css/Join.css';
import { Link } from 'react-router-dom';

const Join = () => {
  return (
    <div className="Join">
      <div className="header">
        <Link to="/">HOME</Link> | <Link to="/help">HELP</Link>
      </div>
      <div className="logo">Join</div>
      <div className="form">
        <input type="text" placeholder="아이디"></input>
        <input type="password" placeholder="비밀번호"></input>
        <input type="text" placeholder="별명"></input>
        <input type="email" placeholder="이메일"></input>
      </div>
    </div>
  );
};

export default Join;
