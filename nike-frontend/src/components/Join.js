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
  const [userPhone, setUserPhone] = useState('');
  const [isDuplicated, setIsDuplicated] = useState(false);

  const sendSms = () => {
    axios({
      method: 'POST',
      url: 'http://localhost:8080/api/sendsms',
      data: {
        phoneNumber: userPhone,
        certificationNumber: null,
      },
    });
  };
  const setValueHandler = (e) => {
    if (e.target.name === 'id') {
      setUserId(e.target.value);
      duplicatedChecker(e.target.value);
    } else if (e.target.name === 'nickname') {
      setUserNickname(e.target.value);
    } else if (e.target.name === 'phone') {
      setUserPhone(e.target.value);
    }
  };
  const duplicatedChecker = (userId) => {
    if (userId.length > 0) {
      axios({
        method: 'GET',
        url: 'http://localhost:8080/api/checkid/' + userId,
      }).then((res) => {
        if (res.data) {
          setIsDuplicated(true); //중복이다.
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
            autoComplete="off"
          ></input>
          {userId.length > 3 ? (
            isDuplicated ? (
              <p style={{ color: 'rgba(255, 0, 0, 0.7)' }}>
                사용할 수 없는 아이디입니다 🥲
              </p>
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
          <input
            type="tel"
            placeholder="휴대폰 번호를 입력하세요"
            value={userPhone}
            name="phone"
            onChange={setValueHandler}
          ></input>
          <button type="button" onClick={sendSms}>
            인증하기
          </button>
        </label>
      </div>
      <div className="footer">
        <button type="button">CREATE</button>
      </div>
    </div>
  );
};

export default Join;
