import React from 'react';
import { GrMenu } from 'react-icons/gr';

const Menu = () => {
  const activeMenu = () => {
    document.getElementsByClassName('menu')[0].classList.toggle('active');
  };
  const unActiveMenu = (e) => {
    document.getElementsByClassName('menu')[0].classList.remove('active');
  };
  return (
    <div className="menu" onClick={activeMenu}>
      <button type="button" onClick={unActiveMenu}>
        X
      </button>
      MENU
    </div>
  );
};

export default Menu;
