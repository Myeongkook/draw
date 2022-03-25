import React from 'react';
import Menu from './Menu';
import '../index.css';
import NavigatorBar from './NavigatorBar';
import { GiHamburgerMenu } from 'react-icons/gi';

const Layout = ({ children }) => {
  const activeMenu = () => {
    document.getElementsByClassName('menu')[0].classList.toggle('active');
  };
  return (
    <div className="Layout">
      <div className="header">
        <GiHamburgerMenu onClick={activeMenu} />
        <Menu />
      </div>
      {children}
      <NavigatorBar />
    </div>
  );
};

export default Layout;
