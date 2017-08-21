import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LocationStrategy, HashLocationStrategy, CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';

import { DropdownModule } from 'primeng/primeng';
import { DataGridModule } from 'primeng/primeng';     //accordion and accordion tab
import { MenuItem } from 'primeng/primeng';            //api
import { DataListModule } from 'primeng/primeng';

import { AppComponent } from './app.component';
import { VehicleComponent } from './components/cars/vehicles.component';
import { HomeComponent } from './components/home/home.component';
import { SupportComponent } from './components/support/support.component';
import { VehicleService } from './service/vehicle.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SupportComponent,
    VehicleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    BrowserAnimationsModule, 
    CommonModule,
    DropdownModule,
    DataListModule
//    DataGridModule
  ],
  providers: [
      { provide: LocationStrategy, useClass: HashLocationStrategy },
      VehicleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }