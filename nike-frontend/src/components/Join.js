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
      <div className="join-form">
        <label>
          ID<input type="text" placeholder="ID를 입력하세요"></input>
        </label>
        <label>
          Password<input type="password" placeholder="PW를 입력하세요"></input>
        </label>
        <label>
          Nickname<input type="text" placeholder="닉네임 입력하세요"></input>
        </label>
        <label>
          Phone<input type="tel" placeholder="휴대폰 번호를 입력하세요"></input>
        </label>
      </div>
      <div className="footer">
        <button type="button">CREATE</button>
      </div>
    </div>
  );
};

export default Join;
