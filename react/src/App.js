
import React, { useState } from 'react';

function App() {

 const data = {
  java:['file1.txt','file3.txt'],
  python:['file2.txt'],
  hashmap:['file3.txt']
 };

 const [keyword,setKeyword] = useState('');

 return (
  <div style={{padding:'20px'}}>
   <h1>Smart File Search Engine</h1>

   <input
    placeholder='Enter keyword'
    value={keyword}
    onChange={(e)=>setKeyword(e.target.value)}
   />

   <h3>Results</h3>

   <ul>
    {(data[keyword.toLowerCase()] || []).map((file,index)=>(
      <li key={index}>{file}</li>
    ))}
   </ul>
  </div>
 );
}

export default App;
