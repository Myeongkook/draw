import React from 'react';

const DrawItem = ({ draw }) => {
  const connectPage = () => {
    window.open('https://m.nike.com');
  };
  const { product_name, img, draw_date } = draw;
  return (
    <div className="draw-item">
      <div className="img">
        <img src={img} alt={product_name} />
      </div>
      <div className="draw-content">
        <div className="product">{product_name}</div>
        <div className="date">{draw_date}</div>
        <button type="button" onClick={connectPage}>
          응모
        </button>
      </div>
    </div>
  );
};

export default DrawItem;
