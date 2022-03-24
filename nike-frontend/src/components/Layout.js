import React from 'react';
import Menu from './Menu';
import '../index.css';
import NavigatorBar from './NavigatorBar';

const Layout = ({ children }) => {
  return (
    <div className="Layout">
      <Menu />
      {children}
      <NavigatorBar />
    </div>
  );
};

export default Layout;
