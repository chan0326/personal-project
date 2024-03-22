'use client'

import { useState } from "react"
import axios from 'axios';
const SERVER = 'http://localhost:8080/'
import Link from "next/link";
          
export default function Home() {
const [name,setName] = useState('')  
const handleonChange = (e:any)=>{
  setName(e.target.value)
}
const handleonClick = ()=>{
  alert('리퀴스트가 가져가는 이름 '+name)
  const url =`${SERVER}/name`
  const data = {'name':name}
  const config = {

    headers:{
    
    "Cache-Control": "no-cache",
    
    "Content-Type": "application/json",
    
    Authorization: `Bearer blah ~` ,
    
    "Access-Control-Allow-Origin": "*",
    
    }}
  axios.post(url,data,config)
  .then(res=>{
    alert(JSON.stringify("리스폰스가 가져온 이름 : "+JSON.stringify(res.data)))
  })
}
  return (<>
  <div>안녕하세요</div>
  <h2>이름이 뭐에요?</h2>
  <input type="text"onChange={handleonChange} />
  <button onClick={handleonClick}>입력</button><br />
  <Link href={"/login"}>로그인</Link><br />
  <Link href={"/join"}>회원가입</Link>
  </>
  );
}
