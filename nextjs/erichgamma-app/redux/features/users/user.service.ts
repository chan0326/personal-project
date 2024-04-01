import { createAsyncThunk } from "@reduxjs/toolkit";
import { getAllUsersAPI } from "./user.api";

export const fetchAllUsers: any = createAsyncThunk('users/fetchAllUsers',
async(page:number, {rejectWithValue})=>{
    console.log('fetchAllUsers page:'+ page)

    const data:any = await  getAllUsersAPI(1);

    const {message, result}:any = data
        // console.log('----- API 를 사용한 경우 -----')
        // console.log('message : '+ message)
        // console.log(JSON.stringify(result))
        return data

}
)