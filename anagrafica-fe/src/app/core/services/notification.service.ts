import { Injectable } from "@angular/core";
import { RxStomp } from "@stomp/rx-stomp";
import { map } from "rxjs/operators";
import { webSocket } from 'rxjs/webSocket';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  stompConfig = {
    brokerURL: "ws://localhost:8080/anagrafica-api/my-socket",
    reconnectDelay: 1000,
  };

  connect(){

    const socket = new RxStomp();
    socket.configure(this.stompConfig)

    socket.activate();

    return socket.watch('push-notifications').pipe(
      map((message) => {
        return JSON.parse(message.body);
      })
    );

  }
}

