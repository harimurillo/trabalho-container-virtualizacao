import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './views/home/home.component';
import { ListaDespesasComponent } from './views/home/despesas/lista-despesas.component';
import { CreateDespesasComponent } from './views/home/despesas/create-despesas/create-despesas.component';
import { DeleteDespesasComponent } from './views/home/despesas/delete-despesas/delete-despesas.component';
import { MenuComponent } from './views/home/despesas/menu/menu.component';
import { UpdateDespesasComponent } from './views/home/despesas/update-despesas/update-despesas.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListaDespesasComponent,
    CreateDespesasComponent,
    DeleteDespesasComponent,
    MenuComponent,
    UpdateDespesasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
