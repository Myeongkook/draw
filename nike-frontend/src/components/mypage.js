import React from 'react';
import Layout from './Layout';
import { GrKey } from 'react-icons/gr';
import { BiShoppingBag, BiMessageCheck, BiLogOut } from 'react-icons/bi';

const Mypage = () => {
  return (
    <Layout>
      <div className="content">
        <div className="mypage">
          <div className="header">MY PAGE</div>
          <div className="content">
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
                <BiLogOut />
                LOGOUT
              </li>
            </ul>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Mypage;
