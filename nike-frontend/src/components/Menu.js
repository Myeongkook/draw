import React from 'react';
import { GiCancel } from 'react-icons/gi';
import { Link } from 'react-router-dom';

const Menu = () => {
  const unActiveMenu = (e) => {
    document.getElementsByClassName('menu')[0].classList.toggle('active');
    console.log(document.getElementsByClassName('menu')[0].classList);
  };
  return (
    <div className="menu">
      <div className="header">
        <GiCancel onClick={unActiveMenu} />
        MENU
      </div>
      <div className="menu-items">
        <ul>
          <Link to="/mypage">
            <li>My Page</li>
          </Link>
          <li>Re-Sell</li>
          <li>Draw</li>
          <li>Logout</li>
        </ul>
      </div>
      <div className="footer">Untitled App</div>
    </div>
  );
};

export default Menu;
