

import axios from "axios"
import { useEffect, useState } from "react"
import Chart from "react-apexcharts"
import { VendaSuccess } from "types/venda"
import { round } from "utils/format"
import { BASE_URL } from "utils/requests"

type SeriesData={
    name:string;
    data:number[];
}
type ChartData ={
    labels:{
        categories:string[];

    };
    series: SeriesData[];
}

const BarChart = () => {

    const [ chartData , setChartData ] = useState <ChartData> ({
        labels: {
            categories: [],
        },
        series: [
            {
                name:"",
                data: []
            }
        ]
    })
    useEffect(() => {
        axios.get(BASE_URL + '/vendas/success-by-vendedor')
            .then(Response => {
                const data = Response.data as VendaSuccess[];
                const myLabels = data.map(x => x.vendedorName);
                const mySeries = data.map(x => round(100.0*x.fechamento / x.visitado,1));


                setChartData({
        labels: {
            categories: myLabels,
        },
        series: [
            {
                name:"%Success",
                data: mySeries
            }
        ]
    });
                console.log(chartData)

            });
    }, []);
    const options = {
        plotOptions: {
            bar: { 
                horizontal: true,
            }
        },
    };

    //const mockData = {
       // labels: {
           // categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
       // },
       // series: [
          //  {
              //  name: "% Sucesso",
              //  data: [43.6, 67.1, 67.7, 45.6, 71.1]
           // }
        //]
  //  };
    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"

        />

    );
}

export default BarChart;
