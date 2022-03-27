import React from 'react';
import { Link } from 'react-router-dom';

const Help = () => {
  return (
    <div className="help">
      <div className="header">
        <Link to="/">HOME</Link> | <Link to="/help">HELP</Link>
      </div>
      <div className="logo">Help</div>
      <div className="content"></div>
    </div>
  );
};

export default Help;
