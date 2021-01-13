/*List*/
export interface Despesa {
    id: number;
    descricao: string;
    dataDespesa: string;
    valor: string;
    categoria: string;
}

export interface ResponseDespesas {
    id: number;
    descricao: string;
    dataDespesa: string;
    valor: string;
    categoria: string;
    // data: Despesa[];
}

/*Create*/

export interface RequestCreate {
    descricao: string;
    dataDespesa: string;
    valor: string;
    categoria: string;
}

export interface ResponseCreate {
    descricao: string;
    dataDespesa: string;
    valor: string;
    categoria: string;
}

/* Get User */

export interface ResponseDespesa {
    data: Despesa;
}
