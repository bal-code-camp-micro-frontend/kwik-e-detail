import { Component } from '@angular/core';
import { Location } from '@angular/common'
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'kwik-e-detail';
  text = ""
  json;
  productid;
  productname;
  productimgurl;
  producttype;
  productprice;

  constructor(private location: Location, private http: HttpClient) {
    this.location.onUrlChange((url,state) => this.render(url));
    console.log(this.location.path())
    this.render(location.path())
  }

  render(url) {
    const match = url.match("/product/(.*)");
    if (match && match[1]) {
      this.text = match[1]
      // api call
      this.http.get("/d/api/product/"+this.text).subscribe( (o) => (this.json = JSON.parse(<string> o)))
      this.productid = 1 // this.json.id
      this.productname = "ProductName" //(JSON.parse(this.json)).name
      this.productprice = 123 // (JSON.parse(this.json)).price
      this.productimgurl = "https://static.simpsonswiki.com/images/2/24/Count_Branula.png" // (JSON.parse(this.json)).imageUrl
      this.producttype = "food" // (JSON.parse(this.json)).type
    }
  }

  onClickMe(){
    this.location.go("/product/13")
  }
}
