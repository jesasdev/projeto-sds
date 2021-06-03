import { type } from "os"
import { Vendedor } from "./vevdedor"

export type Venda = {
    id: number,
    visitado: number,
    fechamento: number;
    montante: number,
    date: string,
    vendedor:Vendedor,
}

export type VendaPage={
    content?: Venda[];
    last: boolean,
    totalElements: number,
    totalPages: number,
    size?: 10,
    number: number,
    first: boolean,
    numberOfElements?: number,
    empty?: boolean
}

export type VendaSum = {
    vendedorName: string;
    sum: number;
}

export type VendaSuccess={

    vendedorName: string;
    visitado: number;
    fechamento: number;

}