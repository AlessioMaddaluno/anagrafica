import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/persona.model';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-ricerca',
  templateUrl: './ricerca.component.html',
  styleUrls: ['./ricerca.component.css']
})
export class RicercaComponent implements OnInit {

  data: Persona[] = []
  totalPages:number = 1;
  currentPage:number = 0;
  pageSize:number = 5;

  formRicerca = this.formBuilder.group({
    nome: ['', [Validators.pattern("^[a-zA-Z]*$")]],
    cognome: ['', [Validators.pattern("^[a-zA-Z]*$")]],
    etaMin: [''],
    etaMax: [''],
    citta: ['', [Validators.pattern("^[a-zA-Z ]*$")]]
  });

  searchParams: any 

  constructor(private personaService:PersonaService,private formBuilder:FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.onSearch();
  }

  onDelete(id:number){
    this.personaService.deleteById(id).subscribe(() => {
      this.onSearch()
    })
  }

  onEdit(id:number){
    this.router.navigate(['/censimento'], { queryParams: { edit: id } });
  }

  onSearch(page?:number){

    console.log(page,this.totalPages)

    if(this.formRicerca.valid){

      this.searchParams = {
        nome: this.formRicerca.controls.nome.value,
        cognome: this.formRicerca.controls.cognome.value,
        etaMin: this.formRicerca.controls.etaMin.value,
        etaMax: this.formRicerca.controls.etaMax.value,
        citta: this.formRicerca.controls.citta.value,
        page: this.currentPage,
        pageSize: this.pageSize,
        sortBy: 'id',
        sortDirection: 'ASC'
      }

      if(page !== undefined && (page >= 0 || page === this.totalPages)){
        this.currentPage = page;
      }

      this.personaService.search(this.searchParams).subscribe(
        (data) => { 
          this.data = data.content
          this.totalPages = data.totalPages
        }
      )

    }
  }

  onReset() {
    this.formRicerca.reset();
    this.onSearch();
  }

  counter(i:number){
    return new Array(i);
  }

}
