import { Routes,RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { SupportComponent } from './components/support/support.component';
import { VehicleComponent } from './components/cars/vehicles.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            {path: '', component: HomeComponent},
            {path: 'support', component: SupportComponent},
            {path: 'cars', component: VehicleComponent},
            {path: 'motorcycles', component: VehicleComponent},
            {path: 'bus', component: VehicleComponent},
            {path: 'trucks', component: VehicleComponent}
        ])    
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {}
