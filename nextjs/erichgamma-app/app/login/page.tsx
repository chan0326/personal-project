'use client'
import { useState } from "react";
import axios from "axios";
import Link from "next/link";
const SERVER = 'http://localhost:8080'
export default function Login() {
  const [UserName, setUserName] = useState('')
  const [PassWord, setPassWord] = useState('')
  const handelIdChange = (e: any) => {
    setUserName(e.target.value)
  }
  const handelPwChange = (e: any) => {
    setPassWord(e.target.value)
  }
  const handelSubmit = () => {
    alert('' + UserName)
    const url = `${SERVER}/login`
    const data = { UserName,PassWord }
    const config = {

      headers: {

        "Cache-Control": "no-cache",

        "Content-Type": "application/json",

        Authorization: `Bearer blah ~`,

        "Access-Control-Allow-Origin": "*",

      }
    }
    axios.post(url, data, config)
      .then(res => {
        alert(JSON.stringify(res.data))
      })
  }
  
  


  return (<>
    <h2>로그인 화면</h2>
    <h3>ID를입력하세요</h3>
    <input type="text" onChange={handelIdChange} />
    <button onClick={handelSubmit}>입력</button>
    <h3>PassWord를입력하세요</h3>
    <input type="text" onChange={handelPwChange} />
    
  </>);
}