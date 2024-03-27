'use client'

import { useState } from "react"
import axios from "axios";
import { useRouter } from "next/navigation";
const SERVER = 'http://localhost:8080'
export default function join() {
  const [username, setUsername]=useState('')
  const [password,setPassword]= useState('')
  const [password_verify,setPassword_verify] = useState('')
  const [name, setName] = useState('')
  const [phone, setPhone]= useState('')
  const [job, setJob] = useState('')
  const [height, setHeight]= useState('')
  const [weight, setWeight]= useState('')
  const handleUsername = (e:any)=> {
      setUsername(e.target.value)
  }
  const handlePassword = (e:any)=> {
      setPassword(e.target.value)
  }
  const handlePasswrdVerfiy =(e:any)=>{
      setPassword_verify(e.target.value)
  }
  const handleName = (e:any)=>{
      setName(e.target.value)
  }
  const handlePhone = (e:any)=>{
      setPhone(e.target.value)
  }
  const handleJob = (e:any)=>{
      setJob(e.target.value)
  }
  const handleHeight =(e:any)=>{
      setHeight(e.target.value)
  }
  const handleWeight =(e:any)=>{
      setWeight(e.target.value)
  }
  const router = useRouter();

  const handleClick = () => {
      alert('입력된 값'+username+','+password+','+password_verify+','+name+','+phone+','+job+','+height+','+weight)
      const url = `${SERVER}/api/users/join`
      const data = { username , password, password_verify, name,phone, job, height, weight}
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
              router.push("/login")
          })
  }
    

    return (<>
        <div className="container">
            <h1>Sign Up</h1>
            <p>Please fill in this form to create an account.</p>
            <hr />
            <label htmlFor="name">Name<b></b></label>
            <input type="text"onChange={handleName} placeholder="Enter Name" name="name" required /><br />
            <label htmlFor="username"><b>Username</b></label>
            <input type="text"onChange={handleUsername} placeholder="Enter Username" name="username" required /><br />
            <label htmlFor="psw"><b>Password</b></label>
            <input type="text"onChange={handlePassword} placeholder="Enter Password" name="pssword" required /><br />
            <label htmlFor="psw-repeat"><b>Repeat Password</b></label>
            <input type="text"onChange={handlePasswrdVerfiy} placeholder="Repeat Password" name="psswordAgain" required /><br />
            <label htmlFor="phone"><b>Phone Number</b></label>
            <input type="text"onChange={handlePhone} placeholder="Enter Phone Number" name="phone" required /><br />
            <label htmlFor="job"><b>Job</b></label>
            <input type="text"onChange={handleJob} placeholder="Enter Job" name="job" required /><br />
            <label htmlFor="height"><b>Height</b></label>
            <input type="text"onChange={handleHeight} placeholder="Enter Height" name="height" required /><br />
            <label htmlFor="weight"><b>Weight</b></label>
            <input type="text"onChange={handleWeight} placeholder="Enter Weight" name="weight" required /><br />
            <label>
                <input type="checkbox" checked={true} name="remember" style={{marginBottom:"15px"}} /> Remember me
            </label>
            <p>By creating an account you agree to our <a href="#" style={{color:"dodgerblue"}}>Terms & Privacy</a>.</p>
            <div className="clearfix">
                <button type="button" className="cancelbtn">Cancel</button><br />
                <button type="submit" onClick={handleClick} className="signupbtn">Sign Up</button>
            </div>
        </div>
    </>
    );
}