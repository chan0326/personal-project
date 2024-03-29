'use client'

import CompanyRows from "@/app/components/rows/company-rows";
import { NextPage } from "next";


const Company = (props: ICompany) => {
    return (
			 <tr key={props.id}>
                <td>{props.company}</td>
                <td>{props.contact}</td>
                <td>{props.country}</td>
            </tr>
    );
};

const CompaniesPage: NextPage =()=>{
    return (<>
        <h2>HTML Table</h2>

<table>
    <thead>
    <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Country</th>
  </tr>
    </thead>
    <tbody>
    {CompanyRows().map((v)=>(<Company  {...v} />))}
    </tbody>
</table>
        </>)
}