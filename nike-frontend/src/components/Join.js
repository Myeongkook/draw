import React from 'react';
import '../css/Join.css';
import { Link, useNavigate } from 'react-router-dom';
import { useState } from 'react';
import { RiLockPasswordLine } from 'react-icons/ri';
import { BsTag, BsPhone } from 'react-icons/bs';
import { HiOutlineIdentification } from 'react-icons/hi';
import axios from 'axios';
const Join = () => {
  const navigate = useNavigate();
  const [userId, setUserId] = useState('');
  const [userNickname, setUserNickname] = useState('');
  const [userPhone, setUserPhone] = useState('');
  const [userPassword, setUserPassword] = useState('');
  const [userCertificationNumber, setUserCertificationNumber] = useState('');
  const [isDuplicated, setIsDuplicated] = useState(false);
  const [isDuplicatedNickName, setIsDuplicatedNickName] = useState(false);
  const [isCertificated, setIsCertificated] = useState(false);

  const sendSms = (e) => {
    axios({
      method: 'POST',
      url: 'http://localhost:8080/api/sendsms',
      data: {
        phoneNumber: userPhone,
        certificationNumber: null,
      },
    });
    const form = document.getElementById('certification-form');
    e.target.style.display = 'none';
    form.style.display = 'block';
  };

  const joinUser = () => {
    axios({
      method: 'POST',
      url: 'http://localhost:8080/api/signup',
      data: {
        id: userId,
        pw: userPassword,
        name: userNickname,
        phone: userPhone,
        role: 'USER',
        isSubscribed: false,
      },
    }).then((res) => {
      navigate('/');
    });
  };
  const setValueHandler = (e) => {
    if (e.target.name === 'id') {
      setUserId(e.target.value);
      duplicatedChecker(e.target.value);
    } else if (e.target.name === 'nickname') {
      setUserNickname(e.target.value);
      duplicatedChecker_nickname(e.target.value);
    } else if (e.target.name === 'phone') {
      setUserPhone(e.target.value);
    } else if (e.target.name === 'certificationNumber') {
      setUserCertificationNumber(e.target.value);
    } else if (e.target.name === 'password') {
      setUserPassword(e.target.value);
    }
  };
  const duplicatedChecker = (userId) => {
    if (userId.length > 0) {
      axios({
        method: 'GET',
        url: 'http://localhost:8080/api/checkid/' + userId,
      })
        .then((res) => {
          if (res.data) {
            setIsDuplicated(true); //중복이다.
          } else {
            setIsDuplicated(false);
          }
        })
        .catch((er) => {
          setIsDuplicated(true);
        });
    }
  };
  const duplicatedChecker_nickname = (userNickname) => {
    if (userNickname.length > 0) {
      axios({
        method: 'GET',
        url: 'http://localhost:8080/api/checknickname/' + userNickname,
      })
        .then((res) => {
          if (res.data) {
            setIsDuplicatedNickName(true); //중복이다.
          } else {
            setIsDuplicatedNickName(false);
          }
        })
        .catch((er) => {
          setIsDuplicatedNickName(true);
        });
    }
  };
  const certification = () => {
    axios({
      method: 'post',
      url: 'http://localhost:8080/api/certification',
      data: {
        phoneNumber: userPhone,
        certificationNumber: userCertificationNumber,
      },
    }).then((res) => {
      if (res.data) {
        setIsCertificated(true);
      }
    });
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
          <input
            type="password"
            value={userPassword}
            name="password"
            onChange={setValueHandler}
            placeholder="패스워드를 입력하세요"
          ></input>
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
          {userNickname.length > 2 ? (
            isDuplicatedNickName ? (
              <p style={{ color: 'rgba(255, 0, 0, 0.7)' }}>
                사용할 수 없는 닉네임입니다 🥲
              </p>
            ) : (
              <p>사용가능한 닉네임입니다😃</p>
            )
          ) : undefined}
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
            autoComplete="off"
          ></input>
          <button type="button" onClick={sendSms}>
            인증하기
          </button>
          <label
            id="certification-form"
            style={{ display: 'none', textAlign: 'left', width: '75%' }}
          >
            {isCertificated ? (
              <p style={{ marginTop: '5px', marginLeft: '-20px' }}>
                정상적으로 인증되었습니다👍
              </p>
            ) : (
              <div>
                <input
                  type="text"
                  placeholder="인증번호"
                  value={userCertificationNumber}
                  name="certificationNumber"
                  onChange={setValueHandler}
                  autoComplete="off"
                  style={{ width: '25%', marginLeft: '4%' }}
                />{' '}
                <button type="button" onClick={certification}>
                  인증하기
                </button>
              </div>
            )}
          </label>
        </label>
      </div>
      <div className="footer">
        <button type="button" onClick={joinUser} disabled={false}>
          CREATE
        </button>
      </div>
    </div>
  );
};

export default Join;
