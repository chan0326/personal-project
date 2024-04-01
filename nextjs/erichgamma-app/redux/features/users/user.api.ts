import { instance } from "@/redux/common/configs/axios-config"

export const getAllUsersAPI = async (page:number) =>{
    try {

        const response = await instance.get('/users/all-users',{
            params: {page,limit: 10}
        })
        return response.data
        
    } catch (error) {
        console.log(error)
        return error
        
    }





}