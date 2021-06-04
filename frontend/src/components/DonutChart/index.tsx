



import axios from "axios"
import { useEffect, useState } from "react"
import Chart from "react-apexcharts"
import { VendaSum } from "types/venda"
import { BASE_URL } from "utils/requests"

type ChartData = {
    labels: string[];
    series: number[];

}

const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] })

    useEffect(() => {
        axios.get(`${BASE_URL}/vendas/montante-by-vendedor`)
            .then(Response => {
                const data = Response.data as VendaSum[];
                const myLabels = data.map(x => x.vendedorName);
                const mySeries = data.map(x => x.sum);
                setChartData({ labels: myLabels, series: mySeries });
                console.log(chartData)

            });
    }, []);

    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"

        />

    );
}

export default DonutChart;
