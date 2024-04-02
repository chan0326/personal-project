import { GridColDef } from "@mui/x-data-grid";

export default function Columns() : GridColDef[]{

    return [
        {
            flex:0.04,
            field: 'id',
            minWidth: 30,
            headerName: 'ID',
            renderCell(){
                return<></>
            }
        },
        {
            flex:0.04,
            field: 'title',
            minWidth: 30,
            headerName: 'title',
            renderCell(){
                return<></>
            }
        },
        {
            flex:0.04,
            field: 'content',
            minWidth: 30,
            headerName: 'content',
            renderCell(){
                return<></>
            }
        },
        {
            flex:0.04,
            field: 'registerDate',
            minWidth: 30,
            headerName: 'registerDate',
            renderCell(){
                return<></>
            }
        }
    ]
}