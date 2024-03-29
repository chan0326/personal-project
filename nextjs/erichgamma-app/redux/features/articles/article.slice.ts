import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "../counter/counter.init";
import { getAllArticles } from "./article.service";
import { Pending } from "@mui/icons-material";
import build from "next/dist/build";

const articleThunks = [getAllArticles]
const status = {
    pending:'pending',
    fullfilled : 'fullfilled',
    rejected: 'rejected'
}
const handlePending = (state: any) => {
    
}
const handlefullfilled = (state: any) => {
    
}
const handlerejected = (state: any) => {
    
}

export const articleSlice = createSlice({
    name: "article",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder.addCase(getAllArticles.fullfilled, (state:any,{payload}:any)=>(
            console.log(JSON.stringify(payload))
        )
        
        )
    }
})

export const {} = articleSlice.actions
export default articleSlice.reducer;