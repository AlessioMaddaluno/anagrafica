import { Injectable } from "@angular/core";
import { webSocket } from 'rxjs/webSocket';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  connect(){
    const socket = webSocket('ws://localhost:8080/anagrafica-api/my-socket');

    socket.subscribe(
      a => console.log(a),
      b => console.log(b)
    )
  }
}
