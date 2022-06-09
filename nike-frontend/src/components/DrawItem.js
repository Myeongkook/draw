import React from 'react';

const DrawItem = ({ draw }) => {
  // const connectPage = (url) => {
  //   window.open(url);
  // };
  const { product, imgUrl, date, url } = draw;
  return (
    <div className="draw-item">
      <div className="img">
        <img src={imgUrl} alt={product} />
      </div>
      <div className="draw-content">
        <div className="product">{product}</div>
        <div className="date">{date}</div>
        <button type="button">응모</button>
      </div>
    </div>
  );
};

export default DrawItem;
