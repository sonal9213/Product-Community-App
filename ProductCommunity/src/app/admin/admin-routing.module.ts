import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './components/main-page/main-page.component';
import { ReviewsComponent } from './components/reviews/reviews.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { LoginAdminComponent } from './components/login-admin/login-admin.component';
// import { AuthGuard } from './guards/auth.guard';
// import { authGuard } from './auth.guard';

const routes: Routes = [
  {path:'' ,component:MainPageComponent},
  {path:'reviews',component:ReviewsComponent},
  {path:'AddProduct',component:AddProductComponent},
  {path:'login',component:LoginAdminComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
