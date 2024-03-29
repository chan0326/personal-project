'use client'

import { useState } from "react"
import axios from 'axios';
const SERVER = 'http://localhost:8080/'
import Link from "next/link";
import './globals.css' 
import { Button, Input } from "@mui/material";
import AxiosConfig from "../redux/common/configs/axios-config";
import { PG } from "../redux/common/enums/PG";

export default function Home() {
const [name,setName] = useState('')  
const handleonChange = (e:any)=>{
  setName(e.target.value)
}
const handleonClick = ()=>{
  alert('리퀴스트가 가져가는 이름 '+name)
  axios.post(`${SERVER}/name`,{'name':name},AxiosConfig())
  .then(res=>{
    alert(JSON.stringify("리스폰스가 가져온 이름 : "+JSON.stringify(res.data)))
  })
}
  return (<div className='text-center'>
  <div>안녕하세요</div>
  <h3 className='text-red-500'>이름 입력</h3><br />
  <input type="text"onChange={handleonChange} />
  <Button  onClick={handleonClick}>입력</Button ><br />
  <Link href={`${PG.USER}/login`}>로그인</Link><br />
  <Link href={`${PG.USER}/join`}>회원가입</Link><br />
  <Link href={`${PG.DEMO}/mui-demo`}>MUI 데모</Link><br />
  <Link href={`${PG.DEMO}/counter`}>카운터 데모</Link><br />
  <Link href={`${PG.DEMO}/redux-counter`}>리덕스 카운터 데모</Link><br />
  <Link href={`${PG.BORAD}`}>전체 게시글</Link>
  </div>
  );
}
