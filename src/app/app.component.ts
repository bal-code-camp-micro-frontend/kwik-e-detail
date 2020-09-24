import { Component } from '@angular/core';
import { Location } from '@angular/common'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'kwik-e-detail';
  private text = ""
  constructor(private location: Location) {
    this.location.onUrlChange((url,state) => this.render(url));
    console.log(this.location.path())
    this.render(location.path())
  }
  render(url) {
    this.text = url;
  }

  onClickMe(){
    this.location.go("/product/13")
  }
}
