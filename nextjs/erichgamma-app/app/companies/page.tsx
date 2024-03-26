'use client'
interface ICompany{
    company: String,
    contact: String,
    country: String
}

const Article = (props: ICompany) => {
    return(
        <tr>
             <td>{props.company}</td>
             <td>{props.contact}</td>
             <td>{props.country}</td>
        </tr>
    );

}
const SERVER = 'http://localhost:8080'
export default function Companies(){
    const companies = [
        {company:"Alfreds Futterkiste",contact:"Maria Anders",country:"Germany"},
        {company:"Centro comercial Moctezuma",contact:"Francisco Chang",country:"Mexico"},
        {company:"Ernst Handel",contact:"Roland Mendel",country:"Austria"},
        {company:"Island Trading",contact:"Helen Bennett",country:"UK"},
        {company:"Laughing Bacchus Winecellars",contact:"Yoshi Tannamuri",country:"Canada"},
        {company:"Magazzini Alimentari Riuniti",contact:"Giovanni Rovelli",country:"Italy"}
        
    ]
    const companyList = companies.map((e,v) =>(<Article key={v} company={e.company} contact={e.contact} country={e.country}/> )) 



    return(<>
    <h2>HTML Table</h2>

<table>
    <thead>
        <tr>
            <th>company</th>
            <th>contact</th>
            <th>country</th>
        </tr>
    </thead>
    <body>
    {companyList}
    </body>
</table>
    </>);
}