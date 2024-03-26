'use client'

import axios from "axios";
import { useRouter } from "next/navigation";
import React from "react";
interface IArtcle{
    id:number,
    title: string,
    content: string,
    writer: string,
    registerdate: string
}

const Article = (props: IArtcle) => {
    return(
        <tr key={props.id}>
                
             <td>{props.title}</td>
             <td>{props.content}</td>
             <td>{props.writer}</td>
             <td>{props.registerdate}</td>

             
        </tr>
    );

};

const SERVER = 'http://localhost:8080'
export default function Articles(){
    const router = useRouter();
    const url = `${SERVER}/api/users`
    const config = {
        headers: {
            "Cache-Control": "no-cache",
            "Content-Type": "application/json",
            Authorization: `Bearer blah ~`,
            "Access-Control-Allow-Origin": "*",
        }
    }
    axios.get(url, config)
        .then(res => {
            const message = res.data.message
            alert((message))
            if(message === 'SUCCESS'){
                alert('게시글 불러오기 성공.')
            }else if(message === 'FAil'){
                alert('게시글이 없습니다.')

            }
        })
    const articles = [
        {id:1,title:"",content:"",writer:"",registerdate:""},
        
        
    ]
    const articleList = articles.map((e) =>(<Article {...e}/> )) 



    return(<>
    <h2>HTML Table</h2>

<table>
    <thead>
        <tr>
            <th>title</th>
            <th>content</th>
            <th>writer</th>
            <th>registerdate</th>
        </tr>
    </thead>
    <body>
    {articleList}
    </body>
</table>
    </>);
}