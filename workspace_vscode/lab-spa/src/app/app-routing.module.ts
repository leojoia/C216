import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoTabelaComponent } from './components/produto-tabela/produto-tabela.component';

const routes: Routes = [
  {
    path: 'produtotabela',
    component: ProdutoTabelaComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
