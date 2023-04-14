import { Component, OnInit } from '@angular/core';
import { FarmService } from './service/farm.service'

@Component({
  selector: 'app-farm',
  templateUrl: './farm.component.html',
  styleUrls: ['./farm.component.css']
})

export class FarmComponent {
  farms:any;
  isFetching:boolean = false;
  message:string = '';

  constructor(private farmService: FarmService) { }

  ngOnInit() {
    this.isFetching = true;
    this.farmService.getFarms().subscribe(
      response => {
        this.farms = response;
        console.log("Todo ok");
        this.isFetching = false;
      },
      err => {
        this.message = err.message;
        console.error("Hubo un error");
      })
    //console.log(this.farms);
  }

}
