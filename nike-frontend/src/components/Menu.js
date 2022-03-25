import React from 'react';

const Menu = () => {
  const unActiveMenu = (e) => {
    document.getElementsByClassName('menu')[0].classList.toggle('active');
    console.log(document.getElementsByClassName('menu')[0].classList);
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
