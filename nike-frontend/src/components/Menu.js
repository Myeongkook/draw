import React from 'react';
import { GiCancel } from 'react-icons/gi';
import { Link } from 'react-router-dom';

const Menu = () => {
  const unActiveMenu = (e) => {
    document.getElementsByClassName('menu')[0].classList.toggle('active');
  };

  const closeMenu = (e) => {
    console.log(e);
    console.log('거의 다 ');
  };
  return (
    <div className="menu" onBlur={closeMenu}>
      <div className="header">
        <GiCancel onClick={unActiveMenu} />
        MENU
      </div>
      <div className="menu-items">
        <ul>
          <li>
            <Link to="/mypage">MY PAGE</Link>
          </li>
          <li>
            <Link to="/notice">NOTICE</Link>
          </li>
          <li>
            <Link to="/resell">RE-SELL</Link>
          </li>
          <li>
            <Link to="/draw">DRAW</Link>
          </li>
          <li>
            <Link to="/">LOGOUT</Link>
          </li>
        </ul>
      </div>
      <div className="footer">Untitled App</div>
    </div>
  );
};

export default Menu;
