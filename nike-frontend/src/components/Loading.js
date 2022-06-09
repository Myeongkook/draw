import React from 'react';
import { Oval } from 'react-loader-spinner';

const Loading = () => {
  return (
    <div style={{ padding: '185px' }}>
      <Oval color="#2c59b7" height={30} width={30} timeout={3000} />
    </div>
  );
};

export default Loading;
