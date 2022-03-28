import React from 'react';
import Layout from './Layout';
import { GrKey } from 'react-icons/gr';
import { BiShoppingBag, BiMessageCheck, BiUserCircle } from 'react-icons/bi';
import { MdLogout } from 'react-icons/md';
import { Link } from 'react-router-dom';

const Mypage = () => {
  return (
    <Layout>
      <div className="content">
        <div className="mypage">
          <div className="header">MY PAGE</div>
          <div className="content">
            <div className="profile">
              <BiUserCircle />
              USER
            </div>
            <ul>
              <li>
                <BiShoppingBag />
                MY DEAL
              </li>
              <li>
                <GrKey />
                PASSWORD CHANGE
              </li>
              <li>
                <BiMessageCheck />
                SUBSCRIPTION
              </li>
              <li>
                <Link to="/">
                  <MdLogout />
                  LOGOUT
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Mypage;
