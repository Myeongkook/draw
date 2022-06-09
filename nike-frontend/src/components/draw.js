import React, { useEffect, useState } from 'react';
import '../css/draw.css';
import Layout from '../components/Layout';
import DrawItem from './DrawItem';
import axios from 'axios';
import Loading from './Loading';

const Draw = () => {
  const [draws, setDraws] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    axios({
      method: 'GET',
      url: 'http://localhost:8080/api/draws',
    })
      .then((draws) => {
        setDraws(draws.data);
        setIsLoading(false);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <Layout>
      <div className="content">
        <div className="draw">
          <div className="header">THE DRAW</div>
          <div className="content">
            {isLoading ? (
              <Loading />
            ) : (
              draws.map((d) => <DrawItem key={d.id} draw={d} />)
            )}
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Draw;
