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
            setIsDuplicated(true); //????????????.
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
            setIsDuplicatedNickName(true); //????????????.
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
            placeholder="ID??? ???????????????"
            value={userId}
            onChange={setValueHandler}
            autoComplete="off"
          ></input>
          {userId.length > 3 ? (
            isDuplicated ? (
              <p style={{ color: 'rgba(255, 0, 0, 0.7)' }}>
                ????????? ??? ?????? ?????????????????? ????
              </p>
            ) : (
              <p>??????????????? ??????????????????????</p>
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
            placeholder="??????????????? ???????????????"
          ></input>
        </label>
        <label>
          Nickname <br />
          <BsTag />
          <input
            type="text"
            name="nickname"
            placeholder="????????? ???????????????"
            value={userNickname}
            onChange={setValueHandler}
          ></input>
          {userNickname.length > 2 ? (
            isDuplicatedNickName ? (
              <p style={{ color: 'rgba(255, 0, 0, 0.7)' }}>
                ????????? ??? ?????? ?????????????????? ????
              </p>
            ) : (
              <p>??????????????? ??????????????????????</p>
            )
          ) : undefined}
        </label>
        <label>
          Phone <br />
          <BsPhone />
          <input
            type="tel"
            placeholder="????????? ????????? ???????????????"
            value={userPhone}
            name="phone"
            onChange={setValueHandler}
            autoComplete="off"
          ></input>
          <button type="button" onClick={sendSms}>
            ????????????
          </button>
          <label
            id="certification-form"
            style={{ display: 'none', textAlign: 'left', width: '75%' }}
          >
            {isCertificated ? (
              <p style={{ marginTop: '5px', marginLeft: '-20px' }}>
                ??????????????? ?????????????????????????
              </p>
            ) : (
              <div>
                <input
                  type="text"
                  placeholder="????????????"
                  value={userCertificationNumber}
                  name="certificationNumber"
                  onChange={setValueHandler}
                  autoComplete="off"
                  style={{ width: '25%', marginLeft: '4%' }}
                />{' '}
                <button type="button" onClick={certification}>
                  ????????????
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
