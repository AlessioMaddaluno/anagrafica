import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { finalize, tap } from "rxjs/operators";
import { SpinnerService } from "../services/spinner.service";


@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    constructor(private spinnerService:SpinnerService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        this.spinnerService.showSpinner();

        if (localStorage.getItem('JWT_TOKEN')) {
            request = request.clone({setHeaders: {Authorization: `Bearer ${localStorage.getItem('JWT_TOKEN')}`}});
        }
        return next.handle(request).pipe(
            finalize(() => this.spinnerService.hideSpinner())
        );
    }

}
