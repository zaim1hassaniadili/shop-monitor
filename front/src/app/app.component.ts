import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  isOpen: Boolean = false;
  url: string = "http://localhost:8080/subscribe";
  eventSource: EventSource = new EventSource(this.url);
  constructor() {
    this.connect()
  }

  connect(): void {
    let source = new EventSource(this.url);
    source.addEventListener('status', message => {
      this.isOpen = JSON.parse(message.data)
      console.log(this.isOpen)
    });

  }
}
