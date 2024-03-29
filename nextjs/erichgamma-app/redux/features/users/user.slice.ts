import { createSlice } from "@reduxjs/toolkit";



interface IUsers{

}

const initialState:IUsers = {}

export const usersSlice = createSlice({
    name: "users",
    initialState,
    reducers: {}
})

export const {} = usersSlice.actions

export default usersSlice.reducer;