import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductPageComponent } from './components/product-page/product-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ProductComponent } from './components/product/product.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { LoginComponent } from './components/login/login.component';




const routes: Routes = [
  {path:'' ,component:HomePageComponent},
  {path:'product',component:ProductPageComponent},
  {path:'product/:id',component:ProductComponent},
  {path:'login', component:LoginComponent},
  {path:'register',component:RegisterUserComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SharedRoutingModule { }
