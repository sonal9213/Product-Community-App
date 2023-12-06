import { StatsService } from './../../services/stats.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
   result:any=[]
  constructor(private StatsService: StatsService){
    this.StatsService.getCount().subscribe(data=>{this.result=data;
      console.log(this.result)});
  }

 

}
