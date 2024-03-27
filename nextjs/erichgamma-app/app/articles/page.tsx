'use client'
import axios from "axios";
import { DataGrid } from "@mui/x-data-grid";
import { useRouter } from "next/navigation";
import React, { useEffect, useState } from "react";
const SERVER = 'http://localhost:8080'
interface IArtcle {
    id: number,
    title: string,
    content: string,
    writer: string,
    registerDate: string
}
export default function Articles() {
    const router = useRouter();
    const [articles, setArticles] = useState([])
    const url = `${SERVER}/api/articles`
    const config = {
        headers: {
            "Cache-Control": "no-cache",
            "Content-Type": "application/json",
            Authorization: `Bearer blah ~`,
            "Access-Control-Allow-Origin": "*",
        }
    }
    useEffect(() => {
        axios.get(url, config)
            .then(res => {
                const message = res.data.message
                console.log((message))
                if (message === 'SUCCESS') {
                    console.log('게시글 불러오기 성공.')
                    const arr = res.data.result
                    for (let a of arr) {
                        console.log(a);
                    }
                    setArticles(res.data.result)

                } else if (message === 'FAil') {
                    console.log('게시글이 없습니다.')

                } else {
                    console.log('지정되지 않은 값')
                }
            })

    }, [])


    return (<>
        <h2>html Table</h2>
        <table>
            <thead>
                <tr>
                    <th>title</th>
                    <th>content</th>
                    <th>writer</th>
                    <th>registerDate</th>
                </tr>
            </thead>
            <tbody>
                {articles.map((props: IArtcle) => (
        <tr key={props.id}>

            <td>{props.title}</td>
            <td>{props.content}</td>
            <td>{props.writer}</td>
            <td>{props.registerDate}</td>
        </tr>))}
            </tbody>
        </table>
    </>
    )
}