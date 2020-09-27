import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddOfferComponent } from './add-offer/add-offer.component';
import { AddUsersComponent } from './add-users/add-users.component';
import { AdminDongleCustomerComponent } from './admin-dongle-customer/admin-dongle-customer.component';
import { AdminPostpaidCustomerComponent } from './admin-postpaid-customer/admin-postpaid-customer.component';
import { AdminPrepaidCustomerComponent } from './admin-prepaid-customer/admin-prepaid-customer.component';
import { BillComponent } from './bill/bill.component';
import { ChatComponent } from './chat/chat.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { LoginComponent } from './login/login.component';
import { PdfgenComponent } from './pdfgen/pdfgen.component';
import { ProfileupdateComponent } from './profileupdate/profileupdate.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path:'',redirectTo:'chat', pathMatch:'full'},
  {path:'viewcust',component:BillComponent},
  {path:'chat',component:ChatComponent},
  {path:'pdfgen',component:PdfgenComponent},
  {path:'register',component:RegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'edit',component:EditUserComponent},
  {path:'customerdetails',component:CustomerDetailsComponent,
  children : [
    {path:'prepaid',component:AdminPrepaidCustomerComponent},
    
    {path:'postpaid',component:AdminPostpaidCustomerComponent},
    {path:'dongle',component:AdminDongleCustomerComponent},
    {path:'adduser',component:AddUsersComponent},
    {path:'addoffer',component:AddOfferComponent},
    {path:'search',component:SearchComponent}
]
  },
  {path:'update',component:ProfileupdateComponent,
  children:[
    {path:'editt',component:EditUserComponent}
  ]
  
  }
    
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
