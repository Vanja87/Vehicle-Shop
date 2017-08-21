import { SelectItem } from 'primeng/components/common/selectitem';
import { Vehicle } from '../../domain/vehicle';
import { VehicleManufacturer } from '../../domain/vehicle-manufacturer';
import { VehicleModel } from '../../domain/vehicle-model';
import { VehicleType } from '../../domain/vehicle-type';
import { VehicleService } from '../../service/vehicle.service';
import { Component, OnInit } from '@angular/core';
import { DataGridModule } from 'primeng/primeng';
import { Header } from 'primeng/primeng';
import { Footer } from 'primeng/primeng';

import { DropdownModule } from 'primeng/primeng';
import { DataListModule } from 'primeng/primeng';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    providers: [VehicleService],
    templateUrl: 'vehicles.view.html'
})
export class VehicleComponent implements OnInit {
  
    manufacturers: SelectItem[];
    
    selectedVehicleManufacturer: VehicleManufacturer;

    models: SelectItem[];
    
    selectedVehicleModel: VehicleModel;
  
    vehicles: Vehicle[];

    selectedVehicle: Vehicle;
    
    displayDialog: boolean;

    vehicleTypeName: String;

    vehicleModelName: String;

    vehicleManufacturerName: String;

    caption: String;
    
    constructor(private vehicleService: VehicleService,
                private router: Router) { }

    ngOnInit() {

        this.vehicleTypeName = this.router.url.substring(1);

        this.caption = this.vehicleTypeName.charAt(0).toUpperCase() + this.vehicleTypeName.slice(1).toLowerCase();

        this.manufacturers = [];
        this.vehicleService
           .getVehicleManufacturersByType(this.vehicleTypeName)
           .subscribe(data => {
                data.forEach(element => {
                    this.manufacturers.push({label: element.name, value: element})           
                });
            });

            console.log('manufacturer: ' + this.selectedVehicleManufacturer);

        if (this.vehicleManufacturerName === undefined) {
            this.vehicleManufacturerName = null;
        }
        if (this.vehicleModelName === undefined) {
            this.vehicleModelName = null;
        }
        this.models = [];
        this.vehicleService
           .getVehicleModelsByManufacturer(this.vehicleTypeName, 
                                           this.vehicleManufacturerName)
           .subscribe(data => {
                data.forEach(element => {
                    this.models.push({label: element.name, value: element})           
                });
            });
        this.updateListOfVehicles();
    }

    updateListOfVehicles() {
        this.vehicles = [];
        this.vehicleService.getVehicle(this.vehicleTypeName,
                                       this.vehicleManufacturerName, 
                                       this.vehicleModelName)
                           .subscribe(data => this.vehicles = data);
                           console.log('vehicles' + this.vehicles);
    }
  
    selectVehicle(vehicle: Vehicle) {
        this.selectedVehicle = vehicle;
        this.displayDialog = true;
    }
    
    onDialogHide() {
        this.selectedVehicle = null;
    }

    onChangeManufacturer(selectedVehicleManufacturer: VehicleManufacturer) {
        this.vehicleManufacturerName = selectedVehicleManufacturer.name;
        this.updateListOfVehicles();
    
    }

    onChangeModel(selectedVehicleModel: VehicleModel) {
        this.vehicleModelName = selectedVehicleModel.name;
        this.updateListOfVehicles();
    
    }

}