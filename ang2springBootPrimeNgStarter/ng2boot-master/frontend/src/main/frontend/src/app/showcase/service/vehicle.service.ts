import { Injectable } from '@angular/core';
import { Http, Response , Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/Rx';

@Injectable()
export class VehicleService {
    
    constructor(private http: Http) {}
  
    getVehicle(typeName: String, manufacturerName: String, modelName: String) {
      return this.http.get('api/vehicles/' + typeName + '/' + manufacturerName + '/' + modelName)
        .do( res => console.log('HTTP response:', res))
        .map(res => res.json());
    }

    getVehicleManufacturersByType(typeName: String) {
      return this.http.get('api/vehicle-manufacturers/' + typeName)
      .do( res => console.log('HTTP response:', res))
      .map(res => res.json());
    }

    getVehicleModelsByManufacturer(typeName: String, manufacturerName: String) {
      return this.http.get('api/vehicle-models/' + typeName + '/' + manufacturerName)
      .do( res => console.log('HTTP response:', res))
      .map(res => res.json());
    }

}