import axios from "axios";
import { format } from "date-fns";
import { useEffect, useState } from "react";
import { VendaPage } from "types/venda";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";


const DataTable = () => {

    const[page ,setPage ] = useState<VendaPage>({
        first:true,
        last:true,
        number:0,
        totalElements:0,
        totalPages: 0,
    });
useEffect(()=>{
    axios.get(BASE_URL+ '/vendas?page=1&size=10&sort=date,desc').then(response =>{
        setPage(response.data);
    })
})
    return (
<div className="table-responsive">
    <table className="table table-striped table-sm">
        <thead>
            <tr>
                <th>Date</th>
                <th>Vendedor</th>
                <th>Clientes visitados</th>
                <th>Negócios fechados</th>
                <th>Valor</th>
            </tr>
        </thead>
        <tbody>
            {page.content?.map( item => (
            <tr key ={item.id}>
                <td>{formatLocalDate(item.date,"dd/MM/yyyy")}</td>
                <td>{item.vendedor.name}</td>
                <td>{item.visitado}</td>
                <td>{item.fechamento}</td>
                <td>{item.montante.toFixed(2)}</td>
            </tr>
    ))}

        </tbody>
    </table>
</div>
    );

}

export default DataTable;