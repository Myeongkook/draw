import React from 'react';
import '../css/draw.css';
import Layout from '../components/Layout';
import DrawItem from './DrawItem';

const Draw = () => {
  const result_api = [
    {
      img: 'img/jordan.png',
      product_id: 1,
      product_name: '에어 조던6',
      draw_date: '4/6 10:00 ~ 10:30',
    },
    {
      img: 'img/kwando.jpeg',
      product_id: 2,
      product_name: '퀀도1',
      draw_date: '4/6 11:00 ~ 12:30',
    },
  ];
  return (
    <Layout>
      <div className="content">
        <div className="draw">
          <div className="header">THE DRAW</div>
          <div className="content">
            {result_api.map((draw) => (
              <DrawItem draw={draw} key={draw.product_id} />
            ))}
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Draw;
