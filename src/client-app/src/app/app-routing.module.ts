import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserCollectionsComponent } from './user-collections/user-collections.component';
import { UserDetailComponent } from './user-detail/user-detail.component';

const routes: Routes = [
  {
    path: "add",
    component: CreateUserComponent
  },
  {
    path:"/all",
    component: UserCollectionsComponent
  },
  {
    path: "/details",
    component: UserDetailComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
