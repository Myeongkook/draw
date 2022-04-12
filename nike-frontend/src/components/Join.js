import React from 'react';
import '../css/Join.css';
import { Link } from 'react-router-dom';
import { useState } from 'react';
import { RiLockPasswordLine } from 'react-icons/ri';
import { BsTag, BsPhone } from 'react-icons/bs';
import { HiOutlineIdentification } from 'react-icons/hi';
import axios from 'axios';
const Join = () => {
  const [userId, setUserId] = useState('');
  const [userNickname, setUserNickname] = useState('');
  const [isDuplicated, setIsDuplicated] = useState(false);

  const joinUser = () => {
    axios({
      method: 'POST',
      url: 'http://localhost:8080/api/signup',
      data: {
        id: userId,
        pw: null,
        name: userNickname,
        salt: null,
        phone: '010-0000-0000',
        role: 'USER',
        isSubscribed: false,
      },
    });
  };
  const setValueHandler = (e) => {
    if (e.target.name === 'id') {
      setUserId(e.target.value);
    } else if (e.target.name === 'nickname') {
      setUserNickname(e.target.value);
    }
  };
  const duplicatedChecker = () => {
    if (userId.length > 0) {
      axios({
        method: 'GET',
        url: 'http://localhost:8080/api/checkid/' + userId,
      }).then((res) => {
        if (res.data) {
          setIsDuplicated(true);
        } else {
          setIsDuplicated(false);
        }
      });
    }
  };
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
          <input
            type="text"
            name="id"
            placeholder="ID를 입력하세요"
            value={userId}
            onChange={setValueHandler}
            onKeyUp={duplicatedChecker}
          ></input>
          {userId.length > 3 ? (
            isDuplicated ? (
              <p>사용할 수 없는 아이디입니다 🥲</p>
            ) : (
              <p>사용가능한 아이디입니다😃</p>
            )
          ) : undefined}
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
          <input
            type="text"
            name="nickname"
            placeholder="닉네임 입력하세요"
            value={userNickname}
            onChange={setValueHandler}
          ></input>
        </label>
        <label>
          Phone <br />
          <BsPhone />
          <input type="tel" placeholder="휴대폰 번호를 입력하세요"></input>
        </label>
      </div>
      <div className="footer">
        <button type="button" onClick={isSubscribed}>
          CREATE
        </button>
      </div>
    </div>
  );
};

export default Join;
