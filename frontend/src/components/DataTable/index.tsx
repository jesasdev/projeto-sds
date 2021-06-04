
import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { VendaPage } from "types/venda";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";



const DataTable = () => {

    const [activPage, setActivePage] = useState(0);

    const [page, setPage] = useState<VendaPage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });
    useEffect(() => {
        axios.get(`${BASE_URL}/vendas?page=${activPage}&size=20&sort,date`)
        .then(response => {
            setPage(response.data)
        });
        }, [activPage]);
    
        const changePage=(index : number)=>{
            setActivePage(index);
    
        }

    return (

        <div className="table-responsive">
            <Pagination page ={page} onPageChange = {changePage} />

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
                    {page.content?.map(item => (
                        <tr key={item.id}>
                            <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                            <td>{item.vendedor.name}</td>
                            <td>{item.visitado}</td>
                            <td>{item.fechamento}</td>
                            <td>{item.montante}</td>
                        </tr>
                    ))}

                </tbody>
            </table>
        </div>

    );

}

export default DataTable;