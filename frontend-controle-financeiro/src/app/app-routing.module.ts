import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateDespesasComponent } from './views/home/despesas/create-despesas/create-despesas.component';
import { DeleteDespesasComponent } from './views/home/despesas/delete-despesas/delete-despesas.component';
import { ListaDespesasComponent } from './views/home/despesas/lista-despesas.component';
import { UpdateDespesasComponent } from './views/home/despesas/update-despesas/update-despesas.component';
import { HomeComponent } from './views/home/home.component';

const routes: Routes = [
  {path: 'lista', component: ListaDespesasComponent},
  {path: 'create', component: CreateDespesasComponent},
  {path: 'lista/update/:id', component: UpdateDespesasComponent},
  {path: 'lista/delete/:id', component: DeleteDespesasComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
