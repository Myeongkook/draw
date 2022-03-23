import React from 'react';

const Menu = () => {
  const unActiveMenu = (e) => {
    e.preventDefault();
    document.getElementsByClassName('menu')[0].classList.remove('active');
  };
  return (
    <div className="menu">
      <button type="button" onClick={unActiveMenu}>
        X
      </button>
      MENU
    </div>
  );
};

export default Menu;
