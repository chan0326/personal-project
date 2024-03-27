'use client'

import { useState } from "react"
import axios from 'axios';
const SERVER = 'http://localhost:8080/'
import Link from "next/link";
import './globals.css' 
import { Button, Input } from "@mui/material";

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
  return (<div className='text-center'>
  <div>안녕하세요</div>
  <h3 className='text-red-500'>이름 입력</h3><br />
  <input type="text"onChange={handleonChange} />
  <Button  onClick={handleonClick}>입력</Button ><br />
  <Link href={"/login"}>로그인</Link><br />
  <Link href={"/join"}>회원가입</Link><br />
  <Link href={"/mui-demo"}>MUI 데모</Link>
  </div>
  );
}
