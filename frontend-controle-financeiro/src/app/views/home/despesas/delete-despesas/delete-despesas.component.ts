import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DespesasService } from '../despesas.service';
import { Despesa } from '../user.model';


@Component({
  selector: 'app-delete-despesas',
  templateUrl: './delete-despesas.component.html',
  styleUrls: ['./delete-despesas.component.css']
})
export class DeleteDespesasComponent implements OnInit {

  despesa!: Despesa;
  response!: string;
  idDespesa: string = '';

  constructor(private despesasService: DespesasService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idDespesa = params['id'];
      this.despesasService.getDespesa(this.idDespesa).subscribe(res => {
        this.despesa = res;
      });
    });
  }

  delete() {
    this.despesasService.deleteDespesa(this.idDespesa).subscribe(res => {
      this.response = "ok";
    })
  }

}
