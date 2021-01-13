import { Component, OnInit } from '@angular/core';
import { DespesasService } from './despesas.service';
import { ResponseDespesas } from './user.model';

@Component({
  selector: 'app-lista-despesas',
  templateUrl: './lista-despesas.component.html',
  styleUrls: ['./lista-despesas.component.css']
})
export class ListaDespesasComponent implements OnInit {

  responseDespesas!: ResponseDespesas[];

  constructor(private despesasService: DespesasService ) { }

  ngOnInit() {
    this.despesasService.getDespesas()
    .subscribe(res => this.responseDespesas = res)
  }
}

