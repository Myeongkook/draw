import React from 'react';
import '../css/Join.css';

const Join = () => {
  return (
    <div className="Join">
      <div className="header">
        <input type="button" value="Back" onClick={console.log('back')}></input>
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
