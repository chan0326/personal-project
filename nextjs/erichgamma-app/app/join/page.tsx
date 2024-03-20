'use client'

import { useState } from "react"
const SERVER = 'http://localhost:8080'
export default function join(){
    const [UserName,setUserName] = useState('')
    const [PassWord,setPassWord] = useState('')
    const handleUserName =(e:any)=>{
        setUserName(e.target.value)
    }
    const handlePassWord =(e:any)=>{
        setPassWord(e.target.value)
    } 
    const handleSubmit = ()=>{
        alert('회원가입')
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
    
}
    return(<>
    <h2>회원가입</h2><br />
    <h3>아이디 입력</h3>
    <input type="text" onChange={handleUserName} />
    <h3>비밀번호 입력</h3>
    <input type="text"onChange={handlePassWord} />
    <button onClick={handleSubmit}>입 력</button>

    
    </>);
}