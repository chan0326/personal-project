import { ReactNode } from "react"

export interface IArticle{
    writer: ReactNode
    id : number
    title : string
    content : string
    registerDate : string
    array: []
    
}