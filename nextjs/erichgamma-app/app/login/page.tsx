'use client'
import { useState } from "react";
import axios from "axios";
import Link from "next/link";
import { useRouter } from "next/navigation";
const SERVER = 'http://localhost:8080'
export default function Login() {
  
  const [username, setUserName] = useState('')
  const [password, setPassWord] = useState('')
  const handelIdChange = (e: any) => {
    setUserName(e.target.value)
  }
  const handelPwChange = (e: any) => {
    setPassWord(e.target.value)
  }
  const router = useRouter();

  const handelSubmit = () => {
    alert('' + username)
    const url = `${SERVER}/api/login`
    const data = { username,password }
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
        const message = res.data.message
        alert(res.data.message)
        if (message == 'SUCCESS'){
          router.push("/articles")

      }else if (message == 'SUCCESS'){
        alert("WRONG_PASSWORD")
      }
      else {
        alert("지정되지 않는 값")
      }
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