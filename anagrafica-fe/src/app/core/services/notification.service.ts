import { Injectable } from "@angular/core";
import { RxStomp } from "@stomp/rx-stomp";
import { map } from "rxjs/operators";
import { webSocket } from 'rxjs/webSocket';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  stompConfig = {
    // Broker URL, should start with ws:// or wss:// - adjust for your broker setup
    brokerURL: "ws://localhost:8080/anagrafica-api/my-socket",
    // If disconnected, it will retry after 200ms
    reconnectDelay: 1000,
  };

  connect(){

    const socket = new RxStomp();
    socket.configure(this.stompConfig)

    socket.activate();

    const rxJsSubscription = socket.watch('push-notifications').pipe(
      map((message) => {
        return message.body;
      })
    ).subscribe((data) => console.log(data))


  }
}

