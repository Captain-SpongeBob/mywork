import React from 'react';

export default (): React.ReactNode => (
  <p style={{ textAlign: 'center' }}>
     <div class="change">
       注册名:<input type="username" /><br/><br/>
	   注册密码:<input type="password" /><br/><br/>
	   <a href="./register"><button type="submit">提交</button></a>
	  </div>
  </p>
);