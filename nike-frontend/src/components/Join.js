import React from 'react';
import '../css/Join.css';
import { Link } from 'react-router-dom';
import { RiLockPasswordLine } from 'react-icons/ri';
import { BsTag, BsPhone } from 'react-icons/bs';
import { HiOutlineIdentification } from 'react-icons/hi';
const Join = () => {
  return (
    <div className="Join">
      <div className="header">
        <Link to="/">HOME</Link> | <Link to="/help">HELP</Link>
      </div>
      <div className="logo">Join</div>
      <div className="join-form">
        <label>
          ID <br />
          <HiOutlineIdentification />
          <input type="text" placeholder="ID를 입력하세요"></input>
        </label>
        <label>
          Password
          <br />
          <RiLockPasswordLine />
          <input type="password" placeholder="패스워드를 입력하세요"></input>
        </label>
        <label>
          Nickname <br />
          <BsTag />
          <input type="text" placeholder="닉네임 입력하세요"></input>
        </label>
        <label>
          Phone <br />
          <BsPhone />
          <input type="tel" placeholder="휴대폰 번호를 입력하세요"></input>
        </label>
      </div>
      <div className="footer">
        <button type="button">CREATE</button>
      </div>
    </div>
  );
};

export default Join;
