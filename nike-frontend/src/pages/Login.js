import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { AiOutlineCheckCircle } from 'react-icons/ai';

function Login() {
  const navigate = useNavigate();
  const [userId, setUserId] = useState('');
  const [userPw, setUserPw] = useState('');
  const setValueHandler = (e) => {
    e.target.name === 'id'
      ? setUserId(e.target.value)
      : setUserPw(e.target.value);
  };

  const createAccount = () => {
    navigate('/join');
  };

  const alertTest = (e) => {
    e.target.classList.toggle('clicked');
  };

  const callLoginApi = (e) => {
    e.preventDefault();
    axios({
      method: 'POST',
      url: 'http://127.0.0.1:8080/api/login',
      data: {
        id: userId,
        pw: userPw,
      },
    }).then((res) => {
      if (res.data) {
        navigate('/home');
      } else {
        window.alert('올바르지 않는 요청입니다.');
      }
    });
  };
  return (
    <div className="Login">
      <div className="header">
        <input type="button" value="Create" onClick={createAccount}></input>
      </div>
      <div className="logo">Untitled App</div>
      <div className="login-form">
        <input
          placeholder="ID"
          name="id"
          value={userId}
          type="text"
          autoComplete="none"
          onChange={setValueHandler}
        ></input>
        <input
          placeholder="PW"
          name="pw"
          type="password"
          value={userPw}
          onChange={setValueHandler}
        ></input>
        <button
          type="submit"
          className="form-btn"
          id="form-btn"
          onClick={callLoginApi}
        >
          login
        </button>
        <div className="footer" onClick={alertTest}>
          <AiOutlineCheckCircle /> remember-me
        </div>
      </div>
    </div>
  );
}

export default Login;
