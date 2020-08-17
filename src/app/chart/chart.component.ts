import { Component } from '@angular/core';
import { StockDataService } from '../stock-data.service';
import { HistoricalData } from '../model';
import { Observable} from 'rxjs';
import{ServiceService} from '../service.service';
@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent {
  
  historicalData: Observable<HistoricalData[]> = this.stockDataService.historicalData;
  single: any[];
  multi: any[];

  view: any[] = [800, 360];

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'date';
  showYAxisLabel = true;
  yAxisLabel = 'Price';
  todayStock:any;
  todayStocka:any;
  todayStockb:any;
  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  constructor(private stockDataService: StockDataService,private service : ServiceService) {
    this.single = this.stockDataService.getStaticData();
    this.todayStock = {date :'',adjClose :'',close:'',high:'',open:'',volume:'',low:''};
    this.todayStockb = {date :'',adjClose :'',close:'',high:'',open:'',volume:'' ,low:''};
    this.todayStocka = {date :'',adjClose :'',close:'',high:'',open:'',volume:'' ,low:''};
  }
  ngOnInit(): void {
    this.service.gettingNseByDate().subscribe((result:any)=>{
      this.todayStocka = result ;
      this.todayStock = result;
      console.log(result)}); 
      this.service.gettingBseByDate().subscribe((result:any)=>{
        this.todayStockb = result;
        console.log(result)});
     
     }
  
 

  
}