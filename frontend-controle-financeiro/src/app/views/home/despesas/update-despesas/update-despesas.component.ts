import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DespesasService } from '../despesas.service';
import { RequestCreate } from '../user.model';

@Component({
  selector: 'app-update-despesas',
  templateUrl: './update-despesas.component.html',
  styleUrls: ['./update-despesas.component.css']
})
export class UpdateDespesasComponent implements OnInit {

  id!: string;

  request!: RequestCreate;

  response!: string;

  idDespesa: string = '';
  
  constructor(private despesasService: DespesasService, private route: ActivatedRoute) { }

  ngOnInit() {
   
    this.route.params.subscribe(params => {
      this.idDespesa = params['id'];

      this.despesasService.getDespesa(this.idDespesa).subscribe(res => {
        this.request = {
          descricao: res.descricao,
          dataDespesa: res.dataDespesa,
          valor: res.valor,
          categoria: res.categoria
        }
      });
    });
  }

  update(){ 
    this.despesasService.updateDespesas(this.idDespesa, this.request).subscribe(res => {
      this.response = "ok"; 
    })
  }
}
