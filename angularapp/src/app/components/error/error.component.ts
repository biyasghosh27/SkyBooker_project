import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: `<h2>404 - Page not found</h2>`
})
export class ErrorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
